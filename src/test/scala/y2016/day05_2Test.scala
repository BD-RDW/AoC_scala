package y2016

import org.scalatest.FunSuite
import y2016.day05_2.{determinePassword, getHashThatStartsWithFiveZeros}

class day05_2Test  extends FunSuite {

  test("Check getting a hash that has 5 leading zeros") {
    assert(getHashThatStartsWithFiveZeros("abc", 0) == ("00000155f8105dff7f56ee10fa9b9abd",3231929))
    assert(getHashThatStartsWithFiveZeros("abc", 3231930) == ("000008f82c5b3924a1ecbebf60344e00",5017308))
    assert(getHashThatStartsWithFiveZeros("abc", 5017309)._1.startsWith("00000f"))
  }
  test("Check generating password") {
    assert(determinePassword("abc") == ("05ace8e3"))
  }
}
