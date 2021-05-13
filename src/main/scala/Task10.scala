package ru.shepelevkirill.kp

/**
 * Дана n x n 2D матрица (двумерный массив) представляющая изображение. Поверните изображение на 90 градусов
 * (по часовой стрелке).
 *
 * Вы должны повернуть изображение на месте, что означает, что вы должны изменить входную 2D матрицу напрямую.
 * НЕ выделяйте другую 2D матрицу.
 */
object Task10 {
  def solution(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    def transposeInPlace(matrix: Array[Array[Int]]): Array[Array[Int]] = {
      for (a <- 1 until matrix.length) {
        for (b <- 0 until a) {
          val temporary = matrix(a)(b)
          matrix(a).update(b, matrix(b)(a))
          matrix(b).update(a, temporary)
        }
      }

      matrix
    }

    def reverseInPlace(matrix: Array[Array[Int]]): Array[Array[Int]] = {
      val n = matrix.length
      for (a <- matrix.indices) {
        for (b <- 0 until n / 2) {
          val temporary = matrix(a)(b)
          matrix(a).update(b, matrix(a)(n - 1 - b))
          matrix(a).update(n - 1 - b, temporary)
        }
      }

      matrix
    }

    reverseInPlace(transposeInPlace(matrix))
  }

  private val matrix1 = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  private val matrix2 = Array(
    Array(5, 1, 9, 11),
    Array(2, 4, 8, 10),
    Array(13, 3, 6, 7),
    Array(15, 14, 12, 16),
  )

  def string(array: Array[Array[Int]]): String =
    array.map(_.mkString("\n  Array(", ", ", ")"))
      .mkString("Array(", ", ", "\n)")

  println(s"Task 10 = ${string(solution(matrix1))}")
  //Task 10 = Array(
  //  Array(7, 4, 1),
  //  Array(8, 5, 2),
  //  Array(9, 6, 3)
  //)

  println(s"Task 10 = ${string(solution(matrix2))}")
  //Task 10 = Array(
  //  Array(15, 13, 2, 5),
  //  Array(14, 3, 4, 1),
  //  Array(12, 6, 8, 9),
  //  Array(16, 7, 10, 11)
  //)
}
