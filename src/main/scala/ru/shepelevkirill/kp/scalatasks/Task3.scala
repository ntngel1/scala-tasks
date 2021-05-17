package ru.shepelevkirill.kp
package scalatasks

/**
 * Дана строка, содержащая прописные/строчные буквы алфавита и символы пробела. Верните длину последнего слова в строке.
 *
 * Слово определяется как последовательность символов, не содержащее пробела.
 * Если последнее слово отсутствует, вернуть 0.
 */
object Task3 {
  def solution(s: String): Int =
    s.trim
      .split(' ')
      .lastOption
      .fold(0)(_.length)

  println(s"Task 3 = ${solution("Hello World")}")
  // Task 3 = 5

  println(s"Task 3 = ${solution("   ")}")
  // Task 3 = 0

  println(s"Task 3 = ${solution(" Bohemian   ")}")
  // Task 3 = 8
}
