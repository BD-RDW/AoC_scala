package y2021

import org.scalatest.FunSuite
import y2021.day06_2.{calculate, determineOffspring}

class day06_2Test  extends FunSuite {

  val testInput = Array("3,4,3,1,2")

  test("Check propreation of a single fish") {
    assert(determineOffspring(3,1).zip(Array((2,1))).filter(z => z._1 != z._2).length == 0) // 2
    assert(determineOffspring(3,2).zip(Array((1,1))).filter(z => z._1 != z._2).length == 0) // 1
    assert(determineOffspring(3,3).zip(Array((0,1))).filter(z => z._1 != z._2).length == 0) // 0
    assert(determineOffspring(3,4).zip(Array((6,1),(8,1))).filter(z => z._1 != z._2).length == 0) // 6 8
    assert(determineOffspring(3,5).zip(Array((5,1),(7,1))).filter(z => z._1 != z._2).length == 0) // 5 7
    assert(determineOffspring(3,6).zip(Array((4,1),(6,1))).filter(z => z._1 != z._2).length == 0) // 4 6
    assert(determineOffspring(3,7).zip(Array((3,1),(5,1))).filter(z => z._1 != z._2).length == 0) // 3 5
    assert(determineOffspring(3,8).zip(Array((2,1),(4,1))).filter(z => z._1 != z._2).length == 0) // 2 4
    assert(determineOffspring(3,9).zip(Array((1,1),(3,1))).filter(z => z._1 != z._2).length == 0) // 1 3
    assert(determineOffspring(3,10).zip(Array((0,1),(2,1))).filter(z => z._1 != z._2).length == 0) // 0 2
    assert(determineOffspring(3,11).zip(Array((1,1),(6,1),(8,1))).filter(z => z._1 != z._2).length == 0) // 6 1 8
    assert(determineOffspring(3,12).zip(Array((0,1),(5,1),(7,1))).filter(z => z._1 != z._2).length == 0) // 5 0 7
    assert(determineOffspring(3,13).zip(Array((4,1),(6,2),(8,1))).filter(z => z._1 != z._2).length == 0) // 4 6 6 8
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

  test("Long running check all") {
    assert(calculate(testInput, 256) == 26984457539L)
  }
}
