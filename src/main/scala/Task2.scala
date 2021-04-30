package ru.shepelevkirill.kp

object Task2 {
  def solution(x: Int): Boolean = {
    def intStream(x: Int): Array[Int] = {
      if (x / 10 == 0) return Array(x)

      Array(x).appendedAll(intStream(x / 10))
    }

    if (x < 0) return false

    val reversed = intStream(x).map(_ % 10)
      .foldLeft(0)((value, digit) => value * 10 + digit)

    reversed == x
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
