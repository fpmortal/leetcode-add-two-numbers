package yspec

import org.scalatest.{FunSuiteLike, MustMatchers}

trait YSpecSuite extends FunSuiteLike with MustMatchers {

  val YSpec = yspec.YSpec

  implicit class YSpecOps[I, O](spec: YSpec[I, O]) {

    def run[O1](actual: I => O1, expected: O => O1): Unit = {
      spec.cases.foreach { tc =>
        test(tc.id) {
          actual(tc.input) mustBe expected(tc.output)
        }
      }
    }
  }
}
