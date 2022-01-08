package y2020

import org.scalatest.FunSuite

class day02_2Test extends FunSuite {

  test("Check Regex in extractDataFromLine") {
    assert(day02_2.extractDataFromLine("1-3 a: abcde") == (1,3,"a","abcde"))
    assert(day02_2.extractDataFromLine("1-3 b: cdefg") == (1,3,"b","cdefg"))
    assert(day02_2.extractDataFromLine("2-9 c: ccccccccc") == (2,9,"c","ccccccccc"))
  }

  test("Check password check") {
    assert(day02_2.isPasswordValid("1-3 a: abcde"))
    assert(! day02_2.isPasswordValid("1-3 b: cdefg"))
    assert(! day02_2.isPasswordValid("2-9 c: ccccccccc"))
  }
}
