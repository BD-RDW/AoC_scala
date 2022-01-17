package y2020

import org.scalatest.FunSuite
import y2020.day05_1.{calculate, decodeChair, decodeRow, processSeatInformation}

class day05_1Test  extends FunSuite {

  test("C hecking seat information") {
    assert(processSeatInformation("FBFBBFFRLR") == 357)
    assert(processSeatInformation("BFFFBBFRRR") == 567)
    assert(processSeatInformation("FFFBBBFRRR") == 119)
    assert(processSeatInformation("BBFFBBFRLL") == 820)
  }

  test("Check determine row") {
    assert(decodeRow("FBFBBFF") == 44)
  }
  test("check determine chair") {
    assert(decodeChair("RLR") == 5)
  }
}
