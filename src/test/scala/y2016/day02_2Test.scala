package y2016

import org.scalatest.FunSuite

class day02_2Test  extends FunSuite {

  test("Check code") {
    assert(day02_2.processInstructions(Array("ULL", "RRDDD", "LURDL", "UUUUD")) == "5DB3")
  }

  test("Check position calculation of digit") {
    assert(day02_2.getDigitCoordinates("1").equals((0,0)))
    assert(day02_2.getDigitCoordinates("2").equals((0,1)))
    assert(day02_2.getDigitCoordinates("3").equals((0,2)))
    assert(day02_2.getDigitCoordinates("4").equals((1,0)))
    assert(day02_2.getDigitCoordinates("5").equals((1,1)))
    assert(day02_2.getDigitCoordinates("6").equals((1,2)))
    assert(day02_2.getDigitCoordinates("7").equals((2,0)))
    assert(day02_2.getDigitCoordinates("8").equals((2,1)))
    assert(day02_2.getDigitCoordinates("9").equals((2,2)))
  }

  test("Check next position on keypad") {
    assert(day02_2.nextKeypadPosition("1", "L") == "1")
    assert(day02_2.nextKeypadPosition("1", "U") == "1")
    assert(day02_2.nextKeypadPosition("1", "R") == "1")
    assert(day02_2.nextKeypadPosition("1", "D") == "3")
    assert(day02_2.nextKeypadPosition("2", "L") == "2")
    assert(day02_2.nextKeypadPosition("2", "U") == "2")
    assert(day02_2.nextKeypadPosition("2", "R") == "3")
    assert(day02_2.nextKeypadPosition("2", "D") == "6")
    assert(day02_2.nextKeypadPosition("3", "L") == "2")
    assert(day02_2.nextKeypadPosition("3", "U") == "1")
    assert(day02_2.nextKeypadPosition("3", "R") == "4")
    assert(day02_2.nextKeypadPosition("3", "D") == "7")
    assert(day02_2.nextKeypadPosition("4", "L") == "3")
    assert(day02_2.nextKeypadPosition("4", "U") == "4")
    assert(day02_2.nextKeypadPosition("4", "R") == "4")
    assert(day02_2.nextKeypadPosition("4", "D") == "8")
    assert(day02_2.nextKeypadPosition("5", "L") == "5")
    assert(day02_2.nextKeypadPosition("5", "U") == "5")
    assert(day02_2.nextKeypadPosition("5", "R") == "6")
    assert(day02_2.nextKeypadPosition("5", "D") == "5")
    assert(day02_2.nextKeypadPosition("6", "L") == "5")
    assert(day02_2.nextKeypadPosition("6", "U") == "2")
    assert(day02_2.nextKeypadPosition("6", "R") == "7")
    assert(day02_2.nextKeypadPosition("6", "D") == "A")
    assert(day02_2.nextKeypadPosition("7", "L") == "6")
    assert(day02_2.nextKeypadPosition("7", "U") == "3")
    assert(day02_2.nextKeypadPosition("7", "R") == "8")
    assert(day02_2.nextKeypadPosition("7", "D") == "B")
    assert(day02_2.nextKeypadPosition("8", "L") == "7")
    assert(day02_2.nextKeypadPosition("8", "U") == "4")
    assert(day02_2.nextKeypadPosition("8", "R") == "9")
    assert(day02_2.nextKeypadPosition("8", "D") == "C")
    assert(day02_2.nextKeypadPosition("9", "L") == "8")
    assert(day02_2.nextKeypadPosition("9", "U") == "9")
    assert(day02_2.nextKeypadPosition("9", "R") == "9")
    assert(day02_2.nextKeypadPosition("9", "D") == "9")
    assert(day02_2.nextKeypadPosition("A", "L") == "A")
    assert(day02_2.nextKeypadPosition("A", "U") == "6")
    assert(day02_2.nextKeypadPosition("A", "R") == "B")
    assert(day02_2.nextKeypadPosition("A", "D") == "A")
    assert(day02_2.nextKeypadPosition("B", "L") == "A")
    assert(day02_2.nextKeypadPosition("B", "U") == "7")
    assert(day02_2.nextKeypadPosition("B", "R") == "C")
    assert(day02_2.nextKeypadPosition("B", "D") == "D")
    assert(day02_2.nextKeypadPosition("C", "L") == "B")
    assert(day02_2.nextKeypadPosition("C", "U") == "8")
    assert(day02_2.nextKeypadPosition("C", "R") == "C")
    assert(day02_2.nextKeypadPosition("C", "D") == "C")
    assert(day02_2.nextKeypadPosition("D", "L") == "D")
    assert(day02_2.nextKeypadPosition("D", "U") == "B")
    assert(day02_2.nextKeypadPosition("D", "R") == "D")
    assert(day02_2.nextKeypadPosition("D", "D") == "D")
  }

}
