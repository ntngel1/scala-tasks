package ru.shepelevkirill.kp

/**
 * По заданной строке найдите длину самой длинной подстроки без повторяющихся символов.
 */
object Task8 {
  def solution(s: String): Int =
    s.scanLeft("")((substring, char) => if (substring.contains(char)) char.toString else substring + char)
      .maxBy(_.length)
      .length

  println(s"Task 8 = ${solution("abcabcbb")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("bbbbb")}")
  // Task 8 = 1

  println(s"Task 8 = ${solution("pwwkew")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("")}")
  // Task 8 = 0

  println(s"Task 8 = ${solution("pwwwwwwkity")}")
  // Task 8 = 5
}
