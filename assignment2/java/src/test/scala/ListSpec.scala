
import org.scalatest.{WordSpec, Matchers}
import org.scalatest.prop.PropertyChecks

import java.lang.IndexOutOfBoundsException

class ListSpec extends WordSpec with Matchers with PropertyChecks {

  "A LinkedList" when {
    def mkTarget = new LinkedList[Int]
    "containing zero elements" should {
      "be empty" in {
        val target = mkTarget
        target shouldBe empty
      }
      "have length zero" in {
        val target = mkTarget
        target.length shouldEqual 0
      }
      "throw an IndexOutOfBoundsException when accessing any non-negative index" in {
        forAll { (idx: Int) => whenever (idx >= 0) {
            val target = mkTarget
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message s"Invalid index $idx"
          }
        }
      }
      "throw an IndexOutOfBoundsException when accessing any negative index" in {
        forAll { (idx: Int) => whenever (idx < 0) {
            val target = mkTarget
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message "List indices must be greater than zero."
          }
        }
      }
    }
    "containing one or more elements" should {
      "have length equal to the number of elements" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            target.length shouldEqual elems.length
          }
        }
      }
      "have each element at the index corresponding to the order it was added" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            elems.zipWithIndex foreach {
              case (value, index) => target.get(index) shouldEqual value
            }
          }
        }
      }
      "not be empty" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            target should not be 'empty
          }
        }
      }
      "throw an IndexOutOfBoundsException when accessing any negative index" in {
        forAll { (idx: Int, elems: Seq[Int]) => whenever (idx < 0 && elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message "List indices must be greater than zero."
          }
        }
      }
    }
  }

  "An ArrayList" when {
    def mkTarget = new ArrayList[Int]
    "containing zero elements" should {
      "be empty" in {
        val target = mkTarget
        target shouldBe empty
      }
      "have length zero" in {
        val target = mkTarget
        target.length shouldEqual 0
      }
      "throw an IndexOutOfBoundsException when accessing any non-negative index" in {
        forAll { (idx: Int) => whenever (idx >= 0) {
            val target = mkTarget
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message s"Invalid index $idx"
          }
        }
      }
      "throw an IndexOutOfBoundsException when accessing any negative index" in {
        forAll { (idx: Int) => whenever (idx < 0) {
            val target = mkTarget
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message "List indices must be greater than zero."
          }
        }
      }
    }
    "containing one or more elements" should {
      "have length equal to the number of elements" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            target.length shouldEqual elems.length
          }
        }
      }
      "have each element at the index corresponding to the order it was added" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            elems.zipWithIndex foreach {
              case (value, index) => target.get(index) shouldEqual value
            }
          }
        }
      }
      "not be empty" in {
        forAll { (elems: Seq[Int]) => whenever (elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            target should not be 'empty
          }
        }
      }
      "throw an IndexOutOfBoundsException when accessing any negative index" in {
        forAll { (idx: Int, elems: Seq[Int]) => whenever (idx < 0 && elems != Nil) {
            val target = mkTarget
            elems foreach { target append _ }
            the [IndexOutOfBoundsException] thrownBy target.get(idx) should have message "List indices must be greater than zero."
          }
        }
      }
    }
  }
}
