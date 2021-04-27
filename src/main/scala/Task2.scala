package ru.shepelevkirill.kp

// TODO Imperative to functional?
object Task2 {
  def solution(x: Int): Boolean = {
    var buffer = x
    var reversed = 0
    while (buffer > 0) {
      reversed = reversed * 10 + buffer % 10
      buffer /= 10
    }

    x == reversed
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
