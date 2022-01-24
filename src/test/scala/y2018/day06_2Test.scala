package y2018

import org.scalatest.FunSuite
import y2018.day06_2._

class day06_2Test  extends FunSuite {

  val testInput = Array(
    "1, 1",
    "1, 6",
    "8, 3",
    "3, 4",
    "5, 5",
    "8, 9"
  )
  val checkArray = Array(
    "          ",
    "          ",
    "          ",
    "   ###    ",
    "  #####   ",
    "  #####   ",
    "   ###    ",
    "          ",
    "          ",
    "          "
  )
  test("Determine filled area") {
    val filledArray = fillArea(processInput(testInput), 32)
    assert(filledArray.flatMap(r => r).mkString == checkArray.flatMap(r => r).mkString)
  }

  test("Check closest distance") {
    val area = Array.fill(10,10)(-1)
    assert(getDistanceIndicator(processInput(testInput), 0, 4, 32) == ' ')
    assert(getDistanceIndicator(processInput(testInput), 3, 3, 32) == '#')
    assert(getDistanceIndicator(processInput(testInput), 3, 9, 32) == ' ')
    assert(getDistanceIndicator(processInput(testInput), 5, 6, 32) == '#')
  }

  test("Check largest finite area") {
    assert(getAreaSize(fillArea(processInput(testInput), 32), testInput.length) == 16)
  }
}
