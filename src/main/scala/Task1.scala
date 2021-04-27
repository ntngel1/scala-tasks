package ru.shepelevkirill.kp

// TODO Unit tests
object Task1 {
  def solution(nums: Array[Int], target: Int): Array[Int] = {
    nums.zipWithIndex
      .combinations(2)
      .find(x => {
        val (firstValue, _) = x.head
        val (secondValue, _) = x.last
        firstValue + secondValue == target
      })
      .fold(Array.empty[Int])(list => Array(list.head._2, list(1)._2))
  }

  def printSolution(nums: Array[Int], target: Int): Unit = {
    println(s"Task1. nums = ${nums.toList}, target = $target, solution = ${solution(nums, target).toList}")
  }

  printSolution(Array(2, 7, 11, 15), 9)
  printSolution(Array(3, 2, 4), 6)
  printSolution(Array(3, 3), 6)
}
