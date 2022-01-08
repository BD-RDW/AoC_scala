package y2021

import org.scalatest.FunSuite

class day01_2Test extends FunSuite {

  test("Determine increasing measurements") {
    assert(day01_2.findNumberOfIncreasingMeasurementWindows(Array(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)) == 5)
  }

}
