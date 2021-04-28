package ru.shepelevkirill.kp

object Task7 {
  def solution(nums: Array[Int]): Boolean = {
    if (nums.length == 1) return true
    if (nums.head == 0) return false

    for (a <- 1 to nums.head) {
      if (solution(nums.drop(a))) return true
    }

    false
  }

  println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
  // Task 7 = true

  println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
  // Task 7 = false

  println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
  // Task 7 = true
}
