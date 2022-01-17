package y2015

import org.scalatest.FunSuite
import y2015.day05_1.{calculate, containsALetterAppearingTwice, containsThreeVowels, notContainingCertainStrings}

class day05_1Test  extends FunSuite {

  val input1 = Array(
    "ugknbfddgicrmopn",   //nice
    "jchzalrnumimnmhp",   // naughty because it has no double letter.
    "haegwjzuvuyypxyu",   // naughty because it contains the string xy.
    "dvszwmarrgswjxmb",    // naughty because it contains only one vowel
    "aaa"
  )

  test("Determine ...") {
    assert(calculate(input1) == 2)
  }

  test("Check vowels") {
    assert(containsThreeVowels(input1(0)))
    assert(containsThreeVowels(input1(1)))
    assert(containsThreeVowels(input1(2)))
    assert(!containsThreeVowels(input1(3)))
    assert(containsThreeVowels("aaa"))
  }
  test("Check for character appearing twice") {
    assert(containsALetterAppearingTwice(input1(0)))
    assert(!containsALetterAppearingTwice(input1(1)))
    assert(containsALetterAppearingTwice(input1(2)))
    assert(containsALetterAppearingTwice(input1(3)))
    assert(containsALetterAppearingTwice("aaa"))
  }
  test("Check string does not contain certain strings") {
    assert(notContainingCertainStrings(input1(0)))
    assert(notContainingCertainStrings(input1(1)))
    assert(!notContainingCertainStrings(input1(2)))
    assert(notContainingCertainStrings(input1(3)))
    assert(notContainingCertainStrings("aaa"))
  }
}
