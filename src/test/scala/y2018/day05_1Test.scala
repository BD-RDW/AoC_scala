package y2018

import org.scalatest.FunSuite
import y2018.day05_1.{calculate, processReactions}

class day05_1Test  extends FunSuite {

  test("Determine ...") {
    assert(calculate("dabAcCaCBAcCcaDA") == 10)
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
}
