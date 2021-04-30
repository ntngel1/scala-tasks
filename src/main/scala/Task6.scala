package ru.shepelevkirill.kp

object Task6 {
  case class ListNode(var x: Int = 0, var next: ListNode = null)

  def solution(l1: ListNode, l2: ListNode): ListNode = {
    def recursiveSum(l1: ListNode, l2: ListNode, swap: Int = 0): ListNode = {
      val sum = l1.x + l2.x + swap

      if (l1.next == null || l2.next == null) {
        val next = if (sum >= 10) {
          ListNode(sum / 10)
        } else {
          null
        }

        return ListNode(sum % 10, next)
      }

      ListNode(sum % 10, recursiveSum(l1.next, l2.next, sum / 10))
    }

    recursiveSum(l1, l2)
  }

  println(s"Task 6 = ${solution(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4))))}")
  // Task 6 = ListNode(7,ListNode(0,ListNode(8,null)))

  println(s"Task 6 = ${solution(ListNode(), ListNode())}")
  // Task 6 = ListNode(0, null)

  println(s"Task 6 = ${solution(ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))), ListNode(9, ListNode(9, ListNode(9, ListNode(9)))))}")
  // Task 6 = ListNode(8,ListNode(9,ListNode(9,ListNode(9,ListNode(0,ListNode(0,ListNode(0,ListNode(1,null))))))))
}
