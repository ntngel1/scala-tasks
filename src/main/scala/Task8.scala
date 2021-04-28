package ru.shepelevkirill.kp

object Task8 {
  def solution(s: String): Int = {
    var characters = Set.empty[Char]
    var currentSubstringLength = 0
    var longestSubstringLength = 0

    s.foreach(char => {
      if (characters.contains(char)) {
        if (currentSubstringLength > longestSubstringLength) {
          longestSubstringLength = currentSubstringLength
        }

        currentSubstringLength = 1
        characters = Set(char)
      } else {
        characters += char
        currentSubstringLength += 1
      }
    })

    if (currentSubstringLength > longestSubstringLength) {
      longestSubstringLength = currentSubstringLength
    }

    longestSubstringLength
  }

  println(s"Task 8 = ${solution("abcabcbb")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("bbbbb")}")
  // Task 8 = 1

  println(s"Task 8 = ${solution("pwwkew")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("")}")
  // Task 8 = 0

  println(s"Task 8 = ${solution("pwwwwwwkity")}")
  // Task 8 = 5
}
