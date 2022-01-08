package y2021

import org.scalatest.FunSuite
import y2021.day03_1.calculate

class day03_1Test  extends FunSuite {

  val input1 = Array(
    "00100",
    "11110",
    "10110",
    "10111",
    "10101",
    "01111",
    "00111",
    "11100",
    "10000",
    "11001",
    "00010",
    "01010"
  )

  test("Determine ...") {
    assert(calculate(input1) == 198)
  }

}
