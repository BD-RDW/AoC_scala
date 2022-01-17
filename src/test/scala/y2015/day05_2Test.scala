package y2015

import org.scalatest.FunSuite
import y2015.day05_2.{aPairOfLettersAppearTwice, calculate, hasRepeatingCharacterWithOneCharacterInBetween}

class day05_2Test  extends FunSuite {

  val input1 = Array(
    "qjhvhtzxzqqjkmpb",   //nice
    "xxyxx",              // nice
    "uurcxstgmygtbstg",   // naughty because it has a pair (tg) but no repeat with a single letter between them.
    "ieodomkazucvgmuy"    // naughty because it has a repeating letter with one between (odo), but no pair that appears twice
  )

  test("Determine ...") {
    assert(calculate(input1) == 2)
  }

  test("Check pair of characters appear twice") {
    assert(aPairOfLettersAppearTwice(input1(0)))
    assert(aPairOfLettersAppearTwice(input1(1)))
    assert(aPairOfLettersAppearTwice(input1(2)))
    assert(!aPairOfLettersAppearTwice(input1(3)))
  }
  test("Check that a character appears twice with one character in between") {
    assert(hasRepeatingCharacterWithOneCharacterInBetween(input1(0)))
    assert(hasRepeatingCharacterWithOneCharacterInBetween(input1(1)))
    assert(!hasRepeatingCharacterWithOneCharacterInBetween(input1(2)))
    assert(hasRepeatingCharacterWithOneCharacterInBetween(input1(3)))
    assert(hasRepeatingCharacterWithOneCharacterInBetween("aaa"))
  }
}
