package y2019

import org.scalatest.FunSuite
import y2019.day04_1.{calculate, pwContainsTwoAdjacentSameDigits, pwDigitsNeverDecrease}

class day04_1Test  extends FunSuite {

//  test("Determine ...") {
//    assert(calculate((111123, 123456)) == 0)
//  }

  test("Check if pw has adjencent same characters") {
    assert(pwContainsTwoAdjacentSameDigits("122345"))
    assert(!pwContainsTwoAdjacentSameDigits("123789"))
    assert(!pwContainsTwoAdjacentSameDigits("123289"))
  }

  test("Check if pw characters never decrease") {
    assert(pwDigitsNeverDecrease("111111"))
    assert(pwDigitsNeverDecrease("111123"))
    assert(pwDigitsNeverDecrease("135679"))
    assert(!pwDigitsNeverDecrease("223450"))
  }
}
