package y2017

import org.scalatest.FunSuite
import y2017.day04_1.{calculate, isValid}

class day04_1Test  extends FunSuite {

  test("Determine ...") {
    assert(calculate(Array("aa bb cc dd ee","aa bb cc dd aa","aa bb cc dd aaa")) == 2)
  }

  test("Check valid passwords") {
    assert(isValid("aa bb cc dd ee"))
    assert(!isValid("aa bb cc dd aa"))
    assert(isValid("aa bb cc dd aaa"))
  }

}
