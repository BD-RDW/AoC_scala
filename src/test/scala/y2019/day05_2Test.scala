package y2019

import org.scalatest.FunSuite
import y2019.day05_2.{deconstructInstruction, getDigit, storeResult}

class day05_2Test  extends FunSuite {
  val testArray = Array(1002,4,3,4,33)

  test("Determine previous program result") {
    assert(day05_2.execute(Array(1,9,10,3,2,3,11,0,99,30,40,50)) == 3500)
    day05_2.programInput = "1"
    assert(day05_2.execute(day05_1.input) == 7157989)
  }

  test("Determine program result") {
    assert(day05_2.execute(testArray.clone()) == 99)
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

  test("Testing with option empty") {
    val testOption:Option[Int] = Option.empty
    assert(testOption.isEmpty)
    val testOption2:Option[Int] = Option(3)
    assert(!testOption2.isEmpty)
  }

  test("Checking the equals opCode") {
    day05_2.programInput = "8"
    assert(day05_2.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 1)
    day05_2.programInput = "7"
    assert(day05_2.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 0)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 0)

    day05_2.programInput = "8"
    assert(day05_2.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 1)
    day05_2.programInput = "7"
    assert(day05_2.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 0)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 0)
  }
  test("Checking the less-than opCodes") {
    day05_2.programInput = "8"
    assert(day05_2.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 0)
    day05_2.programInput = "7"
    assert(day05_2.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 1)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 0)

    day05_2.programInput = "8"
    assert(day05_2.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 0)
    day05_2.programInput = "7"
    assert(day05_2.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 1)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 0)
  }

  test("Checking the jump-if-false opCodes") {
    day05_2.programInput = "0"
    assert(day05_2.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 0)
    day05_2.programInput = "-1"
    assert(day05_2.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 1)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 1)
  }

  test("Checking the jump-if-true opCodes") {
    day05_2.programInput = "0"
    assert(day05_2.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 0)
    day05_2.programInput = "-1"
    assert(day05_2.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 1)
    day05_2.programInput = "9"
    assert(day05_2.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 1)
  }

  test("Multiple output commands") {
    day05_2.programInput = "0"
    assert(day05_2.execute(Array(4,31,104,2,4,32,104,4,99,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,3)) == 4)
  }
}
