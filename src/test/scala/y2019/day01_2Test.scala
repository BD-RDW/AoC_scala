package y2019

import org.scalatest.FunSuite

class day01_2Test  extends FunSuite {

  test("Determine fule requirement for mass") {
    assert(day01_2.determineFuelRequirement(Array(14)) == 2)
    assert(day01_2.determineFuelRequirement(Array(1969)) == 966)
    assert(day01_2.determineFuelRequirement(Array(100756)) == 50346)
  }

}
