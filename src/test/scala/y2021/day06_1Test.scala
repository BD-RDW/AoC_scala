package y2021

import org.scalatest.FunSuite
import y2021.day06_1.{calculate, determineOffspring}

class day06_1Test  extends FunSuite {

  val testInput = Array("3,4,3,1,2")

  test("Check propreation of a single fish") {
    assert(determineOffspring(3,1) == 1) // 2
    assert(determineOffspring(3,2) == 1) // 1
    assert(determineOffspring(3,3) == 1) // 0
    assert(determineOffspring(3,4) == 2) // 6 8
    assert(determineOffspring(3,5) == 2) // 5 7
    assert(determineOffspring(3,6) == 2) // 4 6
    assert(determineOffspring(3,7) == 2) // 3 5
    assert(determineOffspring(3,8) == 2) // 2 4
    assert(determineOffspring(3,9) == 2) // 1 3
    assert(determineOffspring(3,10) == 2) // 0 2
    assert(determineOffspring(3,11) == 3) // 6 1 8
    assert(determineOffspring(3,12) == 3) // 5 0 7
    assert(determineOffspring(3,13) == 4) // 4 6 6 8
  }

  test("Determine ...") {
    assert(calculate(testInput, 1) == 5)
    assert(calculate(testInput, 2) == 6)
    assert(calculate(testInput, 3) == 7)
    assert(calculate(testInput, 4) == 9)
    assert(calculate(testInput, 5) == 10)
    assert(calculate(testInput, 6) == 10)
    assert(calculate(testInput, 7) == 10)
    assert(calculate(testInput, 8) == 10)
    assert(calculate(testInput, 9) == 11)
    assert(calculate(testInput, 10) == 12)
    assert(calculate(testInput, 11) == 15)
    assert(calculate(testInput, 12) == 17)
    assert(calculate(testInput, 13) == 19)
    assert(calculate(testInput, 14) == 20)
    assert(calculate(testInput, 15) == 20)
    assert(calculate(testInput, 16) == 21)
    assert(calculate(testInput, 17) == 22)
    assert(calculate(testInput, 18) == 26)
    assert(calculate(testInput, 80) == 5934)
  }

}
