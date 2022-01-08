package y2015

import org.scalatest.FunSuite

class day02_2Test extends FunSuite {

  test("Determine amount to wrapping paper for present") {
    assert(day02_2.calculateLengthOfRibbon(2, 3, 4) == 34)
    assert(day02_2.calculateLengthOfRibbon(1, 1, 10) == 14)
  }

  test("Determine amount to wrapping paper for multiple presents") {
    assert(day02_2.processPresents(Array("2x3x4","1x1x10")) == 48)
  }

}
