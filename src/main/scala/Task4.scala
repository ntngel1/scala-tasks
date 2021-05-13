package ru.shepelevkirill.kp

import scala.annotation.tailrec
import scala.collection.Searching

/**
 * Предположим дан массив чисел отсортированный по возрастанию, и затем повернутый в некоторой опорной точке
 * неизвестной вам заранее (т.е., [0,1,2,4,5,6,7] может стать [4,5,6,7,0,1,2]). И вам дано целевое значение для поиска.
 * Если найдено это значение, то вернуть его индекс, в противном случае вернуть -1.
 *
 * В массиве нет дубликатов.
 * Сложность времени выполнения вашего алгоритма должна быть порядка O(log n).
 */
object Task4 {
  def solution(nums: Array[Int], target: Int): Int = {
    @tailrec
    def findRotationPivot(nums: Array[Int], left: Int, right: Int): Int = {
      val middle = (left + right) / 2

      if (right < left) {
        -1
      } else if (right == left) {
        left
      } else if (middle < right && nums(middle) > nums(middle + 1)) { // if middle is rotation pivot
        middle
      } else if (middle > left && nums(middle) < nums(middle - 1)) { // if previous from middle is rotation pivot
        middle - 1
      } else if (nums(middle) <= nums(left)) { // if rotation pivot somewhere in left part
        findRotationPivot(nums, left, middle - 1)
      } else { // if rotation pivot somewhere in right part
        findRotationPivot(nums, middle + 1, right)
      }
    }

    nums.headOption
      .map { headValue =>
        val rotationPivot = findRotationPivot(nums, 0, nums.length - 1)
        if (headValue <= target) {
          nums.search(target, from = 0, to = rotationPivot - 1)
        } else {
          nums.search(target, from = rotationPivot + 1, to = nums.length)
        }
      }
      .collect { case Searching.Found(index) => index }
      .getOrElse(-1)
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
