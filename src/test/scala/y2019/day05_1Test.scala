package y2019

import org.scalatest.FunSuite
import y2019.day05_1.{deconstructInstruction, getDigit, storeResult}

class day05_1Test  extends FunSuite {
  val testArray = Array(1002,4,3,4,33)

  test("Determine previous program result") {
    assert(day05_1.execute(Array(1,9,10,3,2,3,11,0,99,30,40,50)) == 3500)
  }

  test("Determine program result") {
    assert(day05_1.execute(testArray) == 99)
  }

  test("Check getting a digit from the array") {
    assert(getDigit(testArray, 1, 1) == 4)
    assert(getDigit(testArray, 1, 0) == 33)
  }
  test("Check storing a digit to the array") {
    assert(storeResult(testArray.clone(), 1, 0, 56).zip(Array(1002,4,3,4,56)).filter(z => z._1 != z._2).length == 0)
    assert(storeResult(testArray.clone(), 1, 1, 56).zip(Array(1002,56,3,4,33)).filter(z => z._1 != z._2).length == 0)
  }

    test("Deconstruction of the instruction") {
    assert(deconstructInstruction(11101) == (1,1,1,1))
    assert(deconstructInstruction(0) == (0,0,0,0))
    assert(deconstructInstruction(1001) == (1,0,1,0))
    assert(deconstructInstruction(102) == (2,1,0,0))
  }
}
