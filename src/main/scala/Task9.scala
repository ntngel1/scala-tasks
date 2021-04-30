package ru.shepelevkirill.kp

import scala.annotation.tailrec

object Task9 {
  sealed abstract class Token

  final case class OneTime(char: Char) extends Token

  final case class ZeroOrMoreTimes(char: Char) extends Token

  case object AnyCharOneTime extends Token

  case object AnyCharZeroOrMoreTimes extends Token

  def solution(s: String, p: String): Boolean = {
    def tokenizer(pattern: Array[Char]): Array[Token] = pattern.headOption match {
      case Some('.') if pattern.lift(1).contains('*') =>
        Array(AnyCharZeroOrMoreTimes)
          .appendedAll(
            tokenizer(pattern.drop(2))
          )

      case Some('.') =>
        Array(AnyCharOneTime)
          .appendedAll(
            tokenizer(pattern.drop(1))
          )

      case Some(_) if pattern.lift(1).contains('*') =>
        Array(ZeroOrMoreTimes(pattern.head))
          .appendedAll(
            tokenizer(pattern.drop(2))
          )

      case Some(_) =>
        Array(OneTime(pattern.head))
          .appendedAll(
            tokenizer(pattern.drop(1))
          )

      case None => Array.empty
    }

    @tailrec
    def matcher(string: String, pattern: Array[Token]): Boolean = {
      if (pattern.isEmpty) return string.isEmpty

      pattern.head match {
        case OneTime(char) =>
          if (string.head == char) {
            matcher(string.drop(1), pattern.drop(1))
          }
          else {
            false
          }

        case AnyCharOneTime => matcher(string.drop(1), pattern.drop(1))

        case AnyCharZeroOrMoreTimes => true
        case ZeroOrMoreTimes(char) => matcher(string.dropWhile(_ == char), pattern.drop(1))
      }
    }

    matcher(s, tokenizer(p.toCharArray))
  }

  println(s"Task 9 = ${solution("aa", "a")}")
  // Task 9 = false

  println(s"Task 9 = ${solution("aa", "a*")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("ab", ".*")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("aab", "c*a*b")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("mississippi", "mis*is*p*.")}")
  // Task 9 = false

  println(s"Task 9 = ${solution("mississippi", "mis*is*ip*.")}")
  // Task 9 = true
}
