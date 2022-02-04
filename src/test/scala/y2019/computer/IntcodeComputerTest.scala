package y2019.computer

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class IntcodeComputerTest  extends FunSuite with BeforeAndAfter {

  val testArray = Array(1002,4,3,4,33)
  var intcodeComputer: IntcodeComputer = _

  before {
    intcodeComputer = new IntcodeComputer(Option(5))
  }

  test("Check getting a digit from the array") {
    assert(intcodeComputer.getDigit(testArray, 1, 1) == 4)
    assert(intcodeComputer.getDigit(testArray, 1, 0) == 33)
  }
  test("Check storing a digit to the array") {
    assert(intcodeComputer.storeResult(testArray.clone(), 1, 0, 56).zip(Array(1002,4,3,4,56)).filter(z => z._1 != z._2).length == 0)
    assert(intcodeComputer.storeResult(testArray.clone(), 1, 1, 56).zip(Array(1002,56,3,4,33)).filter(z => z._1 != z._2).length == 0)
  }

  test("Deconstruction of the instruction") {
    assert(intcodeComputer.deconstructInstruction(11101) == (1,1,1,1))
    assert(intcodeComputer.deconstructInstruction(0) == (0,0,0,0))
    assert(intcodeComputer.deconstructInstruction(1001) == (1,0,1,0))
    assert(intcodeComputer.deconstructInstruction(102) == (2,1,0,0))
  }

  test("Checking the equals opCode") {
    var intcodeComputer = new IntcodeComputer(Option(8))
    assert(intcodeComputer.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 1)
    assert(intcodeComputer.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 1)

    intcodeComputer = new IntcodeComputer(Option(7))
    assert(intcodeComputer.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 0)
    assert(intcodeComputer.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 0)

    intcodeComputer = new IntcodeComputer(Option(9))
    assert(intcodeComputer.execute(Array(3,9,8,9,10,9,4,9,99,-1,8)) == 0)
    assert(intcodeComputer.execute(Array(3,3,1108,-1,8,3,4,3,99)) == 0)
  }
  test("Checking the less-than opCodes") {
    var intcodeComputer = new IntcodeComputer(Option(8))
    assert(intcodeComputer.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 0)
    assert(intcodeComputer.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 0)

    intcodeComputer = new IntcodeComputer(Option(7))
    assert(intcodeComputer.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 1)
    assert(intcodeComputer.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 1)

    intcodeComputer = new IntcodeComputer(Option(9))
    assert(intcodeComputer.execute(Array(3,9,7,9,10,9,4,9,99,-1,8)) == 0)
    assert(intcodeComputer.execute(Array(3,3,1107,-1,8,3,4,3,99)) == 0)
  }

  test("Checking the jump-if-false opCodes") {
    var intcodeComputer = new IntcodeComputer(Option(0))
    assert(intcodeComputer.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 0)
    intcodeComputer = new IntcodeComputer(Option(-1))
    assert(intcodeComputer.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 1)
    intcodeComputer = new IntcodeComputer(Option(9))
    assert(intcodeComputer.execute(Array(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9)) == 1)
  }

  test("Checking the jump-if-true opCodes") {
    var intcodeComputer = new IntcodeComputer(Option(0))
    assert(intcodeComputer.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 0)
    intcodeComputer = new IntcodeComputer(Option(-1))
    assert(intcodeComputer.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 1)
    intcodeComputer = new IntcodeComputer(Option(9))
    assert(intcodeComputer.execute(Array(3,3,1105,-1,9,1101,0,0,12,4,12,99,1)) == 1)
  }

  test("Multiple output commands") {
    var intcodeComputer = new IntcodeComputer(Option(0))
    assert(intcodeComputer.execute(Array(4,31,104,2,4,32,104,4,99,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,3)) == 4)
  }

  test("Determine execution step result") {
    val (ptr1, arr1, res1) = intcodeComputer.processInstructionAt((0, Array(1,9,10,3,2,3,11,0,99,30,40,50)))
    assert(ptr1 == 4)
    assert(res1 == 70)
    assert(arr1.length == 12)
    assert(arr1(3) == 70)
    assert(arr1.zip(Array(1,9,10,70,2,3,11,0,99,30,40,50)).filter(x => x._1 != x._2).length == 0)

    val(ptr2,arr2,res2) = intcodeComputer.processInstructionAt((4, Array(1,9,10,70,2,3,11,0,99,30,40,50)))
    assert(ptr2 == 8)
    assert(res2 == 3500)
    assert(arr2(0) == 3500)
    assert(arr2.length == 12)
    assert(arr2.zip(Array(3500,9,10,70,2,3,11,0,99,30,40,50)).filter(x => x._1 != x._2).length == 0)

  }

}
