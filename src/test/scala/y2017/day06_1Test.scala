package y2017

import org.scalatest.FunSuite
import y2017.day06_1.{calculate, getMemoryBankToRedistribute}

class day06_1Test  extends FunSuite {

  val testInput: String = "0\t2\t7\t0"

  test("Determine ...") {
    assert(calculate(testInput) == 5)
  }

  test("Check largest bank") {
    assert(getMemoryBankToRedistribute(testInput.split("\t").map(s => s.toInt)) == 2)
  }

}
