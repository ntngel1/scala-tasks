package ru.shepelevkirill.kp

object Task3 {
  def solution(s: String): Int =
    s.trim
      .replaceAll(" +", " ")
      .split(' ')
      .lastOption
      .fold(0)(string => string.length)

  println(s"Task 3 = ${solution("Hello World")}")
  // Task 3 = 5

  println(s"Task 3 = ${solution("   ")}")
  // Task 3 = 0

  println(s"Task 3 = ${solution(" Bohemian   ")}")
  // Task 3 = 8
}
