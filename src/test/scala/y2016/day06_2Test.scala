package y2016

import org.scalatest.FunSuite
import y2016.day06_2.{calculate, getLeastUsedCharacter}

class day06_2Test  extends FunSuite {

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
    assert(calculate(testInput) == "advent")
  }

  test("Checking most used character") {
    assert(getLeastUsedCharacter(testInput, 0) == 'a')
    assert(getLeastUsedCharacter(testInput, 2) == 'v')
  }
}
