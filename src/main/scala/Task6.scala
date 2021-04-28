package ru.shepelevkirill.kp

object Task6 {
  case class ListNode(var x: Int = 0, var next: ListNode = null)

  def solution(l1: ListNode, l2: ListNode): ListNode = {
    val resultListNode = ListNode()
    var resultTail = resultListNode
    var resultPenultimateNode = resultListNode
    var next1 = Option(l1)
    var next2 = Option(l2)

    while (next1.isDefined || next2.isDefined) {
      val resultX = resultTail.x + next1.fold(0)(_.x) + next2.fold(0)(_.x)

      if (resultX == 0) {
        resultPenultimateNode.next = null
        return resultListNode
      }

      resultTail.x = resultX % 10
      resultTail.next = ListNode(resultX / 10)

      resultPenultimateNode = resultTail
      resultTail = resultTail.next
      next1 = next1.fold(Option.empty[ListNode])(listNode => Option(listNode.next))
      next2 = next2.fold(Option.empty[ListNode])(listNode => Option(listNode.next))
    }

    if (resultTail.x == 0) {
      resultPenultimateNode.next = null
    }

    resultListNode
  }

  println(s"Task 6 = ${solution(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4))))}")
  // Task 6 = ListNode(7,ListNode(0,ListNode(8,null)))

  println(s"Task 6 = ${solution(ListNode(), ListNode())}")
  // Task 6 = ListNode(0, null)

  println(s"Task 6 = ${solution(ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))), ListNode(9, ListNode(9, ListNode(9, ListNode(9)))))}")
  // Task 6 = ListNode(8,ListNode(9,ListNode(9,ListNode(9,ListNode(0,ListNode(0,ListNode(0,ListNode(1,null))))))))
}
