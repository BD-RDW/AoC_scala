package y2018

import org.scalatest.FunSuite
import y2018.day06_1.{calculate, determineFiniteAreas, fillArea, getClosestPoint, getLargestEnclosedAreaSize, processInput}

class day06_1Test  extends FunSuite {

  val testInput = Array(
    "1, 1",
    "1, 6",
    "8, 3",
    "3, 4",
    "5, 5",
    "8, 9"
  )
  val checkArray = Array(
    "00000.2222",
    "00000.2222",
    "0003342222",
    "0033342222",
    "..33344222",
    "11.3444422",
    "111.4444..",
    "111.444555",
    "111.445555",
    "111.555555"
  )
  test("Determine filled area") {
    val filledArray = fillArea(processInput(testInput))
    assert(filledArray.flatMap(r => r).mkString == checkArray.flatMap(r => r).mkString)
  }

  test("Check closest distance") {
    val area = Array.fill(10,10)(-1)
    assert(getClosestPoint(processInput(testInput), 0, 4) == '.')
    assert(getClosestPoint(processInput(testInput), 3, 2) == '3')
    assert(getClosestPoint(processInput(testInput), 3, 9) == '.')
    assert(getClosestPoint(processInput(testInput), 7, 7) == '5')
  }

  test("Check finite area ids") {
    val filledArray = fillArea(processInput(testInput))
    assert(determineFiniteAreas(filledArray, testInput.length).mkString == "34")
  }

  test("Check largest finite area") {
    assert(getLargestEnclosedAreaSize(fillArea(processInput(testInput)), testInput.length) == 17)
  }
}
