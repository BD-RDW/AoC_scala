package y2019

import org.scalatest.FunSuite
import y2019.day04_2.{pwContainsTwoAdjacentSameDigits, pwDigitsNeverDecrease}

class day04_2Test  extends FunSuite {

  test("Check if pw has adjencent same characters") {
    assert(pwContainsTwoAdjacentSameDigits("122345"))
    assert(!pwContainsTwoAdjacentSameDigits("123789"))
    assert(!pwContainsTwoAdjacentSameDigits("111111"))
    assert(pwContainsTwoAdjacentSameDigits("111122"))
    assert(!pwContainsTwoAdjacentSameDigits("123444"))
    assert(pwContainsTwoAdjacentSameDigits("668889"))
    assert(pwContainsTwoAdjacentSameDigits("668999"))
    assert(!pwContainsTwoAdjacentSameDigits("368889"))
    assert(!pwContainsTwoAdjacentSameDigits("168999"))
  }

  test("Check if pw characters never decrease") {
    assert(pwDigitsNeverDecrease("111111"))
    assert(pwDigitsNeverDecrease("111123"))
    assert(pwDigitsNeverDecrease("135679"))
    assert(!pwDigitsNeverDecrease("223450"))
  }

}
