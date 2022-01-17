package y2017

import org.scalatest.FunSuite
import y2017.day05_1.{calculateNumberOfStepsNeededToEscapeTheMaze, moveToNextInstruction}

class day05_1Test  extends FunSuite {

  val input1: Array[Int] = Array(0, 3, 0, 1, -3)

  test("Determine number of steps needed") {
    assert(calculateNumberOfStepsNeededToEscapeTheMaze(input1) == 5)
  }

  test("Check moving along") {
    val step1 = moveToNextInstruction(input1, 0)// == ((1, 3, 0, 1, -3), 0)
    assert(step1._1.zip(Array(1, 3, 0, 1, -3)).filter(z => z._1 != z._2).length == 0)
    assert(step1._2 == 0)
    val step2 = moveToNextInstruction(step1._1, step1._2)// == ((1, 3, 0, 1, -3), 0)
    assert(step2._1.zip(Array(2, 3, 0, 1, -3)).filter(z => z._1 != z._2).length == 0)
    assert(step2._2 == 1)
    val step3 = moveToNextInstruction(step2._1, step2._2)// == ((1, 3, 0, 1, -3), 0)
    assert(step3._1.zip(Array(2, 4, 0, 1, -3)).filter(z => z._1 != z._2).length == 0)
    assert(step3._2 == 4)
    val step4 = moveToNextInstruction(step3._1, step3._2)// == ((1, 3, 0, 1, -3), 0)
    assert(step4._1.zip(Array(2, 4, 0, 1, -2)).filter(z => z._1 != z._2).length == 0)
    assert(step4._2 == 1)
    val step5 = moveToNextInstruction(step4._1, step4._2)// == ((1, 3, 0, 1, -3), 0)
    assert(step5._1.zip(Array(2, 5, 0, 1, -2)).filter(z => z._1 != z._2).length == 0)
    assert(step5._2 == 5)
  }
}
