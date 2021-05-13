package ru.shepelevkirill.kp

/**
 * Проверьте, может ли быть строка интерпретирована как десятичное число.
 *
 * Список символов, которые могут быть в допустимом десятичном числе:
 *   1) Числа от 0 до 9
 *   2) Экспонента - e
 *   3) Положительный/отрицательный знак - +/-
 *   4) Точка в десятичной дроби - .
 *
 * Предпочтительнее решить задачу с помощью регулярного выражения.
 */
object Task12 { // todo  Для ".1", "4.", "-.9", "-90E3" выдает false, хотя должен быть true
  def solution(s: String): Boolean = {
    val integerGroup = "^([\\+-]?\\d+)"
    val fractionalGroup = "(\\.\\d+)?"
    val exponentGroup = "(e[\\+-]?\\d+)?"
    val regex = s"$integerGroup$fractionalGroup$exponentGroup"

    s.trim.matches(regex)
  }

  println(s"Task 12 = ${solution("0")}")         // Task 12 = true
  println(s"Task 12 = ${solution(" 0.1 ")}")     // Task 12 = true
  println(s"Task 12 = ${solution("abc")}")       // Task 12 = false
  println(s"Task 12 = ${solution("1 a")}")       // Task 12 = false
  println(s"Task 12 = ${solution("2e10")}")      // Task 12 = true
  println(s"Task 12 = ${solution(" -90e3   ")}") // Task 12 = true
  println(s"Task 12 = ${solution(" 1e")}")       // Task 12 = false
  println(s"Task 12 = ${solution("e3")}")        // Task 12 = false
  println(s"Task 12 = ${solution(" 6e-1")}")     // Task 12 = true
  println(s"Task 12 = ${solution(" 99e2.5 ")}")  // Task 12 = false
  println(s"Task 12 = ${solution("53.5e93")}")   // Task 12 = true
  println(s"Task 12 = ${solution(" --6 ")}")     // Task 12 = false
  println(s"Task 12 = ${solution("-+3")}")       // Task 12 = false
  println(s"Task 12 = ${solution("95a54e53")}")  // Task 12 = false
}
