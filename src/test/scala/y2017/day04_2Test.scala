package y2017

import org.scalatest.FunSuite
import y2017.day04_2.{calculate, isValid}

class day04_2Test  extends FunSuite {

  test("Determine ...") {
    assert(calculate(Array("abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio")) == 3)
  }

  test("Check valid passwords") {
    assert(isValid("abcde fghij"))
    assert(!isValid("abcde xyz ecdab"))
    assert(isValid("a ab abc abd abf abj"))
    assert(isValid("iiii oiii ooii oooi oooo"))
    assert(!isValid("oiii ioii iioi iiio"))
  }

}
