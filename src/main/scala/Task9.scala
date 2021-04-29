package ru.shepelevkirill.kp

object Task9 {
  sealed abstract class Token

  final case class Symbol(char: Char) extends Token
  final case class Star(char: Char) extends Token
  case object Dot extends Token
  case object DotStar extends Token

  // TODO Implement lexer/parser
  def solution(s: String, p: String): Boolean = {
    def tokenizer(pattern: String): Array[Token] = {
      var index = 0
      var tokens = Array.empty[Token]

      while (index < pattern.length) {
        if (pattern(index) == '.') {
          if (index + 1 < pattern.length && pattern(index + 1) == '*') {
            tokens = tokens.appended(DotStar)
            index += 2
          } else {
            tokens = tokens.appended(Dot)
            index += 1
          }
        } else if (index + 1 < pattern.length && pattern(index + 1) == '*') {
          val char = pattern(index)
          tokens = tokens.appended(Star(char))
          index += 2
        } else {
          tokens = tokens.appended(Symbol(pattern(index)))
          index += 1
        }
      }

      tokens
    }

    def matcher(string: String, pattern: Array[Token]): Boolean = {
      var stringIndex = 0

      for (a <- pattern.indices) {
        pattern(a) match {
          case Symbol(char) if string(stringIndex) == char => stringIndex += 1
          case Star(char) =>
            val charCount = string.drop(stringIndex).takeWhile(_ == char).length
            stringIndex += charCount
          case Dot => stringIndex += 1
          case DotStar => return true
          case _ => return false
        }
      }

      stringIndex == string.length
    }

    matcher(s, tokenizer(p))
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
