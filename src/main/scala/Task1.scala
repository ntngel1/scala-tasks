package ru.shepelevkirill.kp

// TODO Unit tests
object Task1 {
  def solution(nums: Array[Int], target: Int): Array[Int] =
    nums.zipWithIndex
      .combinations(2)
      .find(x => {
        val (firstValue, _) = x.head
        val (secondValue, _) = x.last
        firstValue + secondValue == target
      })
      .fold(Array.empty[Int])(list => Array(list.head._2, list(1)._2))

  println(s"Task 1 = ${solution(Array(2, 7, 11, 15), 9).toList}")
  // Task 1 = List(0, 1)

  println(s"Task 1 = ${solution(Array(3, 2, 4), 6).toList}")
  // Task 1 = List(1, 2)

  println(s"Task 1 = ${solution(Array(3, 3), 6).toList}")
  // Task 1 = List(0, 1)
}
