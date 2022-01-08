package y2018

import org.scalatest.FunSuite

class day01_1Test  extends FunSuite {

  test("DetermineFrequenceTest") {
    assert(day01_1.determineFrequence("+1, +1, +1") == 3)
    assert(day01_1.determineFrequence("+1, +1, -2") == 0)
    assert(day01_1.determineFrequence("-1, -2, -3") == -6)
  }

}
