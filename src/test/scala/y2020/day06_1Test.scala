package y2020

import org.scalatest.FunSuite
import y2020.day06_1.{calculate, processInput}

class day06_1Test  extends FunSuite {

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

  test("Determine ...") {
    assert(calculate(testInput) == 11)
  }

}
