package ru.shepelevkirill.kp

import scala.annotation.tailrec

/**
 * Определите, является ли целое число палиндромом.
 *
 * Целое число является палиндромом, когда оно читается назад также как и вперед.
 * Постарайтесь решить задачу без преобразования числа в строку.
 */
object Task2 {
  def solution(x: Int): Boolean = {
    @tailrec
    def reverse(x: Int, y: Int = 0): Int = if (x % 10 == 0) y else reverse(x / 10, y * 10 + x % 10)

    if (x >= 0) {
      reverse(x) == x
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
