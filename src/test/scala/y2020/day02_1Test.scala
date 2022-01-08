package y2020

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Check Regex in extractDataFromLine") {
    assert(day02_1.extractDataFromLine("1-3 a: abcde") == (1,3,"a","abcde"))
    assert(day02_1.extractDataFromLine("1-3 b: cdefg") == (1,3,"b","cdefg"))
    assert(day02_1.extractDataFromLine("2-9 c: ccccccccc") == (2,9,"c","ccccccccc"))
  }

  test("Check character count") {
    assert(day02_1.chrCount("abcde", "a") == 1)
    assert(day02_1.chrCount("cdefg", "b") == 0)
    assert(day02_1.chrCount("ccccccccc", "c") == 9)
  }

  test("Check password check") {
    assert(day02_1.isPasswordValid("1-3 a: abcde"))
    assert(! day02_1.isPasswordValid("1-3 b: cdefg"))
    assert(day02_1.isPasswordValid("2-9 c: ccccccccc"))
  }
}
