package y2016

import org.scalatest.FunSuite
import y2016.day05_1.{determinePassword, getHashThatStartsWithFiveZeros, md5HashString}

class day05_1Test  extends FunSuite {

  test("Check getting a hash that has 5 leading zeros") {
    assert(getHashThatStartsWithFiveZeros("abc", 0) == ("00000155f8105dff7f56ee10fa9b9abd",3231929))
    assert(getHashThatStartsWithFiveZeros("abc", 3231930) == ("000008f82c5b3924a1ecbebf60344e00",5017308))
    assert(getHashThatStartsWithFiveZeros("abc", 5017309)._1.startsWith("00000f"))
  }
  test("Check generating password") {
    assert(determinePassword("abc") == ("18f47a30"))
  }
}
