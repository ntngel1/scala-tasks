package ru.shepelevkirill.kp

object Task5 {
  def solution(nums: Array[Int]): List[List[Int]] = {
    nums.toSet
      .subsets()
      .map(_.toList)
      .toList
  }

  println(s"Task 5 = ${solution(Array(1, 2, 3))}")
  // Task 5 = List(
  //   List(3),
  //   List(1),
  //   List(2),
  //   List(1, 2, 3),
  //   List(1, 3),
  //   List(2, 3),
  //   List(1, 2),
  //   List()
  // )
}
