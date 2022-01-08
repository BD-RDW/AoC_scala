package y2015

import org.scalatest.FunSuite

class day02_1Test extends FunSuite {

  test("Determine amount to wrapping paper for present") {
    assert(day02_1.calculateWrappingPaper(2, 3, 4) == 58)
    assert(day02_1.calculateWrappingPaper(1, 1, 10) == 43)
    assert(day02_1.calculateWrappingPaper(29, 13, 26) == 3276)
    assert(day02_1.calculateWrappingPaper(11, 11, 14) == 979)
    assert(day02_1.calculateWrappingPaper(27, 2, 5) == 408)
    assert(day02_1.calculateWrappingPaper(6, 10, 13) == 596)
    assert(day02_1.calculateWrappingPaper(15, 19, 10) == 1400)
    assert(day02_1.calculateWrappingPaper(26, 29, 15) == 3548)
    assert(day02_1.calculateWrappingPaper(8, 23, 6) == 788)
    assert(day02_1.calculateWrappingPaper(17, 8, 26) == 1708)
    assert(day02_1.calculateWrappingPaper(20, 28, 3) == 1468)
    assert(day02_1.calculateWrappingPaper(23, 12, 24) == 2508)
  }

  test("Determine amount to wrapping paper for multiple presents") {
    assert(day02_1.processPresents(Array("2x3x4","1x1x10")) == 101)
    assert(day02_1.processPresents(Array("29x13x26", "11x11x14", "27x2x5", "6x10x13", "15x19x10", "26x29x15", "8x23x6", "17x8x26", "20x28x3", "23x12x24")) == 16679)
  }

}
