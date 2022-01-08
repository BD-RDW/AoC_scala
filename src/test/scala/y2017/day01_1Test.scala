package y2017

import org.scalatest.FunSuite

class day01_1Test  extends FunSuite {

  test("DetermineFrequenceTest") {
    assert(day01_1.determineSum("1122") == 3)
    assert(day01_1.determineSum("1111") == 4)
    assert(day01_1.determineSum("1234") == 0)
    assert(day01_1.determineSum("91212129") == 9)
  }

}
