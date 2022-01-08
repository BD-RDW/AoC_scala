package y2016

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Check code") {
    assert(day02_1.processInstructions(Array("ULL", "RRDDD", "LURDL", "UUUUD")) == "1985")
  }

  test("Check position calculation of digit") {
    assert(day02_1.getDigitCoordinates(1).equals((0,0)))
    assert(day02_1.getDigitCoordinates(2).equals((0,1)))
    assert(day02_1.getDigitCoordinates(3).equals((0,2)))
    assert(day02_1.getDigitCoordinates(4).equals((1,0)))
    assert(day02_1.getDigitCoordinates(5).equals((1,1)))
    assert(day02_1.getDigitCoordinates(6).equals((1,2)))
    assert(day02_1.getDigitCoordinates(7).equals((2,0)))
    assert(day02_1.getDigitCoordinates(8).equals((2,1)))
    assert(day02_1.getDigitCoordinates(9).equals((2,2)))
  }

  test("Check next position on keypad") {
    assert(day02_1.nextKeypadPosition(1, "L") == 1)
    assert(day02_1.nextKeypadPosition(1, "U") == 1)
    assert(day02_1.nextKeypadPosition(1, "R") == 2)
    assert(day02_1.nextKeypadPosition(1, "D") == 4)
    assert(day02_1.nextKeypadPosition(2, "L") == 1)
    assert(day02_1.nextKeypadPosition(2, "U") == 2)
    assert(day02_1.nextKeypadPosition(2, "R") == 3)
    assert(day02_1.nextKeypadPosition(2, "D") == 5)
    assert(day02_1.nextKeypadPosition(3, "L") == 2)
    assert(day02_1.nextKeypadPosition(3, "U") == 3)
    assert(day02_1.nextKeypadPosition(3, "R") == 3)
    assert(day02_1.nextKeypadPosition(3, "D") == 6)
    assert(day02_1.nextKeypadPosition(4, "L") == 4)
    assert(day02_1.nextKeypadPosition(4, "U") == 1)
    assert(day02_1.nextKeypadPosition(4, "R") == 5)
    assert(day02_1.nextKeypadPosition(4, "D") == 7)
    assert(day02_1.nextKeypadPosition(5, "L") == 4)
    assert(day02_1.nextKeypadPosition(5, "U") == 2)
    assert(day02_1.nextKeypadPosition(5, "R") == 6)
    assert(day02_1.nextKeypadPosition(5, "D") == 8)
    assert(day02_1.nextKeypadPosition(6, "L") == 5)
    assert(day02_1.nextKeypadPosition(6, "U") == 3)
    assert(day02_1.nextKeypadPosition(6, "R") == 6)
    assert(day02_1.nextKeypadPosition(6, "D") == 9)
    assert(day02_1.nextKeypadPosition(7, "L") == 7)
    assert(day02_1.nextKeypadPosition(7, "U") == 4)
    assert(day02_1.nextKeypadPosition(7, "R") == 8)
    assert(day02_1.nextKeypadPosition(7, "D") == 7)
    assert(day02_1.nextKeypadPosition(8, "L") == 7)
    assert(day02_1.nextKeypadPosition(8, "U") == 5)
    assert(day02_1.nextKeypadPosition(8, "R") == 9)
    assert(day02_1.nextKeypadPosition(8, "D") == 8)
    assert(day02_1.nextKeypadPosition(9, "L") == 8)
    assert(day02_1.nextKeypadPosition(9, "U") == 6)
    assert(day02_1.nextKeypadPosition(9, "R") == 9)
    assert(day02_1.nextKeypadPosition(9, "D") == 9)
  }

}
