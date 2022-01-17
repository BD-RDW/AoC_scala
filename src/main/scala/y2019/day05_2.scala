package y2019

import scala.io.StdIn.readLine

object day05_2 {

  // Result 7873292
  val input = Array(3,225,1,225,6,6,1100,1,238,225,104,0,1101,69,55,225,1001,144,76,224,101,-139,224,224,4,224,1002,223,8,223,1001,224,3,224,1,223,224,223,1102,60,49,225,1102,51,78,225,1101,82,33,224,1001,224,-115,224,4,224,1002,223,8,223,1001,224,3,224,1,224,223,223,1102,69,5,225,2,39,13,224,1001,224,-4140,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,101,42,44,224,101,-120,224,224,4,224,102,8,223,223,101,3,224,224,1,223,224,223,1102,68,49,224,101,-3332,224,224,4,224,1002,223,8,223,1001,224,4,224,1,224,223,223,1101,50,27,225,1102,5,63,225,1002,139,75,224,1001,224,-3750,224,4,224,1002,223,8,223,1001,224,3,224,1,223,224,223,102,79,213,224,1001,224,-2844,224,4,224,102,8,223,223,1001,224,4,224,1,223,224,223,1,217,69,224,1001,224,-95,224,4,224,102,8,223,223,1001,224,5,224,1,223,224,223,1102,36,37,225,1101,26,16,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1107,677,677,224,102,2,223,223,1006,224,329,1001,223,1,223,1108,677,677,224,1002,223,2,223,1006,224,344,1001,223,1,223,107,226,226,224,1002,223,2,223,1006,224,359,101,1,223,223,1008,226,226,224,102,2,223,223,1005,224,374,1001,223,1,223,1107,226,677,224,1002,223,2,223,1006,224,389,1001,223,1,223,1008,677,226,224,1002,223,2,223,1005,224,404,1001,223,1,223,7,677,226,224,102,2,223,223,1005,224,419,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,434,1001,223,1,223,108,226,226,224,102,2,223,223,1006,224,449,1001,223,1,223,108,677,677,224,102,2,223,223,1006,224,464,1001,223,1,223,107,226,677,224,1002,223,2,223,1005,224,479,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,494,1001,223,1,223,107,677,677,224,1002,223,2,223,1006,224,509,101,1,223,223,7,677,677,224,102,2,223,223,1006,224,524,1001,223,1,223,1007,226,677,224,1002,223,2,223,1005,224,539,1001,223,1,223,8,226,677,224,1002,223,2,223,1005,224,554,101,1,223,223,8,677,677,224,102,2,223,223,1005,224,569,101,1,223,223,7,226,677,224,102,2,223,223,1006,224,584,1001,223,1,223,1007,226,226,224,102,2,223,223,1006,224,599,1001,223,1,223,1107,677,226,224,1002,223,2,223,1006,224,614,1001,223,1,223,1108,677,226,224,1002,223,2,223,1005,224,629,1001,223,1,223,1007,677,677,224,102,2,223,223,1006,224,644,1001,223,1,223,108,226,677,224,102,2,223,223,1005,224,659,101,1,223,223,8,677,226,224,1002,223,2,223,1006,224,674,1001,223,1,223,4,223,99,226)

  def main(args: Array[String]): Unit = {
    println(f"The diagnosticd program of ${input.length}%d instructions results in ${execute(input)}%d")
  }

  val emptyIntOption: Option[Int] = Option.empty
  var programInput: String = "5"

  def deconstructInstruction(instruction: Int):(Int, Int, Int, Int) = {
    (instruction % 100,
      (instruction / 100) % 10,
      (instruction / 1000) % 10,
      (instruction / 10000) % 10,
    )
  }

  def getDigit(arr: Array[Int], index: Int, parameterMode: Int): Int = {
    if (parameterMode == 1) arr(index) else arr(arr(index))
  }

  def storeResult(arr: Array[Int], index: Int, parameterMode: Int, result: Int): Array[Int] = {
    if (parameterMode == 1) {  // Immediate mode
       arr(index) = result
    } else {  // positional mode
      arr(arr(index)) = result
    }
    arr
  }

  def readInput():String = {
    programInput
  }

  def addOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"AddOperation; ${getDigit(instr, ptr + 1, paraModeVar1) + getDigit(instr, ptr + 2, paraModeVar2)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1) + getDigit(instr, ptr + 2, paraModeVar2)), ptr+3)
  }
  def multiplyOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"MultiplyOperation; ${getDigit(instr, ptr + 1, paraModeVar1) * getDigit(instr, ptr + 2, paraModeVar2)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1) * getDigit(instr, ptr + 2, paraModeVar2)), ptr+3)
  }
  def requestInputOperation(ptr: Int): (Option[Int], Int) = {
    val input = readInput().toInt
    println(f"Input; ${input}%d")
    (Option(input), ptr+1)
  }
  def printOutputOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int): (Option[Int], Int) = {
    println(f"Output; ${getDigit(instr, ptr + 1, paraModeVar1)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1)), ptr+2)
  }

  def jumpIfTrue(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"jumpIfTrue; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) != 0}%b")
    (Option.empty, if (getDigit(instr, ptr + 1, paraModeVar1) != 0) getDigit(instr, ptr + 2, paraModeVar2) else ptr + 3)
  }
  def jumpIfFalse(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"jumpIfFalse; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) == 0}%b")
    (Option.empty, if (getDigit(instr, ptr + 1, paraModeVar1) == 0) getDigit(instr, ptr + 2, paraModeVar2) else ptr + 3)
  }
  def lessThan(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"lessThan; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) < getDigit(instr, ptr + 2, paraModeVar2)}%b")
    (Option(if (getDigit(instr, ptr + 1, paraModeVar1) < getDigit(instr, ptr + 2, paraModeVar2)) 1 else 0), ptr + 3)
  }
  def equals(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    println(f"equals; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) == getDigit(instr, ptr + 2, paraModeVar2)}%b")
    (Option(if (getDigit(instr, ptr + 1, paraModeVar1) == getDigit(instr, ptr + 2, paraModeVar2)) 1 else 0), ptr + 3)
  }

  def processInstructionAt(tpl: (Int, Array[Int])): (Int, Array[Int], Int) = {
    val(ptr, instr) = tpl
    val(opcode, paraModeVar1, paraModeVar2, paraModeResult) = deconstructInstruction(instr(ptr))
    val(result:Option[Int],newPtr) = opcode match {
      case 1 => addOperation(instr, ptr, paraModeVar1, paraModeVar2)
      case 2 => multiplyOperation(instr, ptr, paraModeVar1, paraModeVar2)
      case 3 => requestInputOperation(ptr)
      case 4 => printOutputOperation(instr, ptr, paraModeVar1)
      case 5 => jumpIfTrue(instr, ptr, paraModeVar1, paraModeVar2)
      case 6 => jumpIfFalse(instr, ptr, paraModeVar1, paraModeVar2)
      case 7 => lessThan(instr, ptr, paraModeVar1, paraModeVar2)
      case 8 => equals(instr, ptr, paraModeVar1,paraModeVar2)
    }

    if (opcode == 4)
      println("output is " + result.get)
    else if (result.isEmpty)
      println("Result is empty")
    else
      println("Result: " + result.get)

    if (opcode == 4)
      (newPtr, instr, result.get)
    else if (result.isEmpty)
      (newPtr, instr, 0)
    else
      (newPtr + 1, storeResult(instr, newPtr, paraModeResult, result.get), result.get)
  }

  def execute(prog: Array[Int]): Int = {
    var stap = 0
    var instrPtr = 0
    var code: Array[Int] = prog
    var latestResult = -1
    println(f"Stap ${stap}%d; Pointer: $instrPtr%d; Array:\t${code.map(s => s.toString + "\t").mkString}%s}")
    println("--------------------------------------------------------")
    while (code(instrPtr) != 99) {
      val(ptr, instr, res) = processInstructionAt((instrPtr, code))
      instrPtr = ptr
      code = instr
      latestResult = res
      stap += 1
      println(f"Stap ${stap}%d; Pointer: $instrPtr%d; Array:\t${code.map(s => s.toString + "\t").mkString}%s}")
      println("--------------------------------------------------------")
    }
    latestResult
  }
}
