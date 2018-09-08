package leetcode

import org.json4s.{DefaultFormats, Formats}
import org.scalatest.{FunSuite, MustMatchers}
import yspec.YSpec

class SolutionTest extends FunSuite with MustMatchers {

  implicit val formats: Formats = DefaultFormats

  val is = ClassLoader.getSystemResourceAsStream("cases.yaml")

  val spec = YSpec.load[Input, List[Int]](is)

  spec.cases.foreach { tc =>
    test(tc.id) {
      val a = listNode(tc.input.a)
      val b = listNode(tc.input.b)

      new leetcode.Solution().addTwoNumbers(a, b) mustBe listNode(tc.output)
    }
  }

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
