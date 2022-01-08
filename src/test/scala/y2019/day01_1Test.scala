package y2019

import org.scalatest.FunSuite

class day01_1Test  extends FunSuite {

  test("Determine fule requirement for mass") {
    assert(day01_1.determineFuelRequirement(Array(12)) == 2)
    assert(day01_1.determineFuelRequirement(Array(14)) == 2)
    assert(day01_1.determineFuelRequirement(Array(1969)) == 654)
    assert(day01_1.determineFuelRequirement(Array(100756)) == 33583)
  }

}
