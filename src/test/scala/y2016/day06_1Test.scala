package y2016

import org.scalatest.FunSuite
import y2016.day06_1.{calculate, getMostUsedCharacter}

class day06_1Test  extends FunSuite {

  val testInput = Array(
    "eedadn",
    "drvtee",
    "eandsr",
    "raavrd",
    "atevrs",
    "tsrnev",
    "sdttsa",
    "rasrtv",
    "nssdts",
    "ntnada",
    "svetve",
    "tesnvt",
    "vntsnd",
    "vrdear",
    "dvrsen",
    "enarar"
  )

  test("Determine ...") {
    assert(calculate(testInput) == "easter")
  }

  test("Checking most used character") {
    assert(getMostUsedCharacter(testInput, 0) == 'e')
    assert(getMostUsedCharacter(testInput, 2) == 's')
  }
}
