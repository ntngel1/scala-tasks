package ru.shepelevkirill.kp
package scalatasks

/**
 * Дан массив неотрицательных целых чисел, где вы изначально располагаетесь на начальном индексе массива.
 * Каждый элемент массива представляет вашу максимальную длину прыжка в этой позиции. Определите, сможете ли вы достичь
 * последнего индекса.
 */
object Task7 {
  def solution(nums: Array[Int]): Boolean = {
    if (nums.length == 1) {
      true
    } else if (nums.headOption.getOrElse(0) == 0) {
      false
    } else {
      for (a <- 1 to nums.headOption.getOrElse(0)) {
        if (solution(nums.drop(a))) return true // TODO Можно ли здесь использовать return? Задача помечена как done но
        //      но return'ы же вроде бы не юзаем?
      }

      false
    }
  }

  println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
  // Task 7 = true

  println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
  // Task 7 = false

  println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
  // Task 7 = true
}
