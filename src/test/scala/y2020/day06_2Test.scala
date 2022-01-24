package y2020

import org.scalatest.FunSuite
import y2020.day06_2.{calculate, determineCount, processInput}

class day06_2Test  extends FunSuite {

  val testInput = Array(
    "abc",
    "",
    "a",
    "b",
    "c",
    "",
    "ab",
    "ac",
    "",
    "a",
    "a",
    "a",
    "a",
    "",
    "b"
  )


  test("Verify input processing") {
    val res = processInput(testInput)
    assert(res.length == 5)
    assert(res(0).length == 1)
    assert(res(1).length == 3)
    assert(res(2).length == 2)
    assert(res(3).length == 4)
    assert(res(4).length == 1)
    assert(res(3).zip(Array("a", "a", "a", "a")).filter(z => z._1 != z._2).length == 0)
  }

  test("counting questions all people answeres yes") {
    val res = processInput(testInput)
    assert(determineCount(res(0)) == 3)
    assert(determineCount(res(1)) == 0)
    assert(determineCount(res(2)) == 1)
    assert(determineCount(res(3)) == 1)
    assert(determineCount(res(4)) == 1)
  }

  test("Determine ...") {
    assert(calculate(testInput) == 6)
  }

}
