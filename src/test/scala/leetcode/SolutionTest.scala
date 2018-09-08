package leetcode

import yspec.YSpecSuite

class SolutionTest extends YSpecSuite {

  YSpec
    .fromResource[Input, List[Int]]("cases.yaml")
    .run(
      input => new leetcode.Solution().addTwoNumbers(
        listNode(input.a),
        listNode(input.b)
      ),
      output => listNode(output)
    )

  private def listNode(ls: List[Int]): ListNode = {
    val ln = new ListNode(ls.head)

    var curr = ln
    for (x <- ls.tail) {
      curr.next = new ListNode(x)
      curr = curr.next
    }

    ln
  }
}

case class Input(a: List[Int], b: List[Int])
