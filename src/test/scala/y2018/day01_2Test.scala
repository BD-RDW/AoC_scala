package y2018

import org.scalatest.FunSuite

class day01_2Test  extends FunSuite {

  test("DetermineFrequenceTest") {
    assert(day01_2.findFrequence("+1, -1") == 0)
    assert(day01_2.findFrequence("+3, +3, +4, -2, -4") == 10)
    assert(day01_2.findFrequence("-6, +3, +8, +5, -6") == 5)
    assert(day01_2.findFrequence("+7, +7, -2, -7, -4") == 14)
  }

}
