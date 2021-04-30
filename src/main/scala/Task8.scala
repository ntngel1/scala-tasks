package ru.shepelevkirill.kp

object Task8 {
  def solution(s: String): Int = {
    case class State(characters: Set[Char] = Set.empty, longestSubstringLength: Int = 0, currentSubstringLength: Int = 0)

    val result = s.foldLeft(State())((state, char) => {
      if (state.characters.contains(char)) {
        State(
          characters = Set(char),
          longestSubstringLength = if (state.currentSubstringLength > state.longestSubstringLength) {
            state.currentSubstringLength
          } else {
            state.longestSubstringLength
          },
          currentSubstringLength = 1
        )
      } else {
        state.copy(characters = state.characters + char, currentSubstringLength = state.currentSubstringLength + 1)
      }
    })

    result.longestSubstringLength.max(result.currentSubstringLength)
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
