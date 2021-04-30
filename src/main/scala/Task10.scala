package ru.shepelevkirill.kp

object Task10 {
  def solution(matrix: Array[Array[Int]]): Array[Array[Int]] =
    matrix.transpose
      .map(_.reverse)

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
