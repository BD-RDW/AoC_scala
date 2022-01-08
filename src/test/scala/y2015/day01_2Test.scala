package y2015

import org.scalatest.FunSuite

class day01_2Test extends FunSuite {

  test("Determine when floor -1 is reached Test") {
    assert(day01_2.determineFloorMinus1(")") == 1)
    assert(day01_2.determineFloorMinus1("()())") == 5)
  }

}
