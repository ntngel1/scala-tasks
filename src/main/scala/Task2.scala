package ru.shepelevkirill.kp

/**
 * Определите, является ли целое число палиндромом.
 *
 * Целое число является палиндромом, когда оно читается назад также как и вперед.
 * Постарайтесь решить задачу без преобразования числа в строку.
 */
object Task2 {
  def solution(x: Int): Boolean = {
    def intStream(x: Int): Array[Int] = {
      if (x / 10 == 0) {
        Array(x)
      } else {
        Array(x).appendedAll(intStream(x / 10))
      }
    }

    if (x > 0) {
      val reversed = intStream(x).map(_ % 10)
        .foldLeft(0)((value, digit) => value * 10 + digit)

      reversed == x
    } else {
      false
    }
  }

  println(s"Task 2 = ${solution(121)}")
  // Task 2 = true

  println(s"Task 2 = ${solution(-121)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(10)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(-101)}")
  // Task 2 = false
}
