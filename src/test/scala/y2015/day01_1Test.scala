package y2015

import org.scalatest.FunSuite

class day01_1Test  extends FunSuite {

  test("Determine the floor that is reached Test") {
    assert(day01_1.determineFloor("(())") == 0)
    assert(day01_1.determineFloor("()()") == 0)
    assert(day01_1.determineFloor("(((") == 3)
    assert(day01_1.determineFloor("(()(()(") == 3)
    assert(day01_1.determineFloor("))(((((") == 3)
    assert(day01_1.determineFloor("())") == -1)
    assert(day01_1.determineFloor("))(") == -1)
    assert(day01_1.determineFloor(")))") == -3)
    assert(day01_1.determineFloor(")())())") == -3)
  }

}
