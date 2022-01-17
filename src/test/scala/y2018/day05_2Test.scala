package y2018

import org.scalatest.FunSuite
import y2018.day05_2.{calculate, determineDistinctUnits, determineStringLengthAfterReactions, processReactions, removeUnitsFromString}

class day05_2Test  extends FunSuite {

  test("Determine length of shortest string when removing a unit") {
    assert(calculate("dabAcCaCBAcCcaDA") == 4)
  }
  test("Determine string length after all reactions") {
    assert(determineStringLengthAfterReactions("dabAcCaCBAcCcaDA") == 10)
  }

  test("One round of reactions") {
    assert(processReactions("aA") ==("", true))
    assert(processReactions("Aa") ==("", true))
    assert(processReactions("AA") ==("AA", false))
    assert(processReactions("aa") ==("aa", false))
    val step1 = processReactions("dabAcCaCBAcCcaDA")
    assert(step1 == ("dabAaCBAcaDA", true))
    val step2 = processReactions(step1._1)
    assert(step2 == ("dabCBAcaDA", true))
    val step3 = processReactions(step2._1)
    assert(step3 == ("dabCBAcaDA", false))
  }

  test("Checking distinct units") {
    assert(determineDistinctUnits("dabAcCaCBAcCcaDA").zip(Array('A', 'B', 'C', 'D')).filter(z => z._1 != z._2).length == 0)
  }
  test("Checking removing unit types from string") {
    assert(removeUnitsFromString("dabAcCaCBAcCcaDA", 'A') == "dbcCCBcCcD")
    assert(removeUnitsFromString("dabAcCaCBAcCcaDA", 'B') == "daAcCaCAcCcaDA")
    assert(removeUnitsFromString("dabAcCaCBAcCcaDA", 'C') == "dabAaBAaDA")
    assert(removeUnitsFromString("dabAcCaCBAcCcaDA", 'D') == "abAcCaCBAcCcaA")
  }
}
