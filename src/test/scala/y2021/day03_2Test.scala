package y2021

import org.scalatest.FunSuite
import y2021.day03_2.{calculate, findCo2ScrubberRate, findLeastCommonBit, findMostCommonBit, findOxygenGeneratorRate}

class day03_2Test  extends FunSuite {

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
    assert(calculate(input1) == 230)
  }

  test("Check most common bit result") {
    assert(Integer.parseInt(findOxygenGeneratorRate(input1),2) == 23)
  }
  test("Check least common bit result") {
    assert(Integer.parseInt(findCo2ScrubberRate(input1),2) == 10)
  }
  test("Check find most common bit") {
    assert(findMostCommonBit(input1, 0) == '1')
  }
  test("Check find least common bit") {
    assert(findLeastCommonBit(input1, 0) == '0')
  }
}
