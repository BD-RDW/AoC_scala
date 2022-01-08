package y2017

import org.scalatest.FunSuite

class day01_2Test extends FunSuite {

  test("DetermineFrequenceTest") {
    assert(day01_2.determineSum("1212") == 6)
    assert(day01_2.determineSum("1221") == 0)
    assert(day01_2.determineSum("123425") == 4)
    assert(day01_2.determineSum("123123") == 12)
    assert(day01_2.determineSum("12131415") == 4)
  }

}
