package ru.shepelevkirill.kp
package scalatasks

import scala.annotation.tailrec

/**
 * Даны два не пустых связных списка, представляющих два неотрицательных целых числа. Цифры хранятся в обратном порядке,
 * и каждый из их узлов содержит одну цифру. Суммируйте два числа и верните их в виде связанного списка.
 *
 * Два числа не содержат нуля в начале, кроме самого числа 0.
 */
object Task6 {
  case class ListNode(var x: Int = 0, var next: ListNode = null)

  def solution(l1: ListNode, l2: ListNode): ListNode = {
    @tailrec
    def recursiveSum(l1: Option[ListNode], l2: Option[ListNode], result: ListNode, returnNode: ListNode): ListNode = {
      val next1 = l1.flatMap { listNode => Option(listNode.next) }
      val next2 = l2.flatMap { listNode => Option(listNode.next) }
      val sum = l1.fold(0)(_.x) + l2.fold(0)(_.x) + result.x
      result.x = sum % 10

      if (sum < 10 && next1.isEmpty && next2.isEmpty) {
        returnNode
      } else {
        result.next = ListNode(sum / 10)
        recursiveSum(next1, next2, result.next, returnNode)
      }
    }

    val result = ListNode()
    recursiveSum(Option(l1), Option(l2), result, result)
  }

  println(s"Task 6 = ${solution(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4))))}")
  // Task 6 = ListNode(7,ListNode(0,ListNode(8,null)))

  println(s"Task 6 = ${solution(ListNode(), ListNode())}")
  // Task 6 = ListNode(0, null)

  println(s"Task 6 = ${solution(ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))), ListNode(9, ListNode(9, ListNode(9, ListNode(9)))))}")
  // Task 6 = ListNode(8,ListNode(9,ListNode(9,ListNode(9,ListNode(0,ListNode(0,ListNode(0,ListNode(1,null))))))))
}
