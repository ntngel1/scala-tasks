package ru.shepelevkirill.kp

import scala.collection.Searching

object Task4 {
  def solution(nums: Array[Int], target: Int): Int = {
    def findRotationPivot(nums: Array[Int], left: Int, right: Int): Int = {
      if (right < left) return -1
      if (right == left) return left

      val middle = (left + right) / 2
      if (middle < right && nums(middle) > nums(middle + 1)) return middle
      if (middle > left && nums(middle) < nums(middle - 1)) return middle - 1
      if (nums(middle) <= nums(left)) return findRotationPivot(nums, left, middle - 1)
      findRotationPivot(nums, middle + 1, right)
    }

    val rotationPivot = findRotationPivot(nums, 0, nums.length - 1)
    val searching = if (nums.head <= target) {
      nums.search(target, from = 0, to = rotationPivot - 1)
    } else {
      nums.search(target, from = rotationPivot + 1, to = nums.length)
    }

    searching match {
      case Searching.Found(index) => index
      case Searching.InsertionPoint(_) => -1
    }
  }

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")
  // Task 4 = 4

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")
  // Task 4 = -1

  println(s"Task 4 = ${solution(Array(1), 0)}")
  // Task 4 = -1

  println(s"Task 4 = ${solution(Array(8, 13, 17, 20, 3, 5, 7), 7)}")
  // Task 4 = 6

  println(s"Task 4 = ${solution(Array(8, 13, 17, 20, 3, 5, 7), 3)}")
  // Task 4 = 4
}
