package ru.shepelevkirill.kp

import scala.collection.mutable.ListBuffer

object Task14 {
  def solution(s: String, wordDict: List[String]): List[String] = {
    val result = ListBuffer.empty[String]

    def split(s: String, buffer: List[String], wordDict: List[String]): Unit = {
      if (s.isEmpty) result.addOne(buffer.mkString(" "))

      for (word <- wordDict) {
        if (s.startsWith(word)) split(s.drop(word.length), buffer.appended(word), wordDict)
      }
    }

    split(s, List.empty, wordDict)
    result.toList
  }

  println(s"Task 14 = ${solution("catsanddog", List("cat", "cats", "and", "sand", "dog"))}")
  // Task 14 = List(
  //   "cats and dog",
  //   "cat sand dog"
  // )

  println(s"Task 14 = ${solution("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))}")
  // Task 14 = List(
  //   "pine apple pen apple",
  //   "pineapple pen apple",
  //   "pine applepen apple"
  // )

  println(s"Task 14 = ${solution("catsandog", List("cats", "dog", "sand", "and", "cat"))}")
  // Task 14 = List()

  println(s"Task 14 = ${solution("abcd", List("a", "abc", "b", "cd"))}")
  // Task 14 = List(a b cd)
}
