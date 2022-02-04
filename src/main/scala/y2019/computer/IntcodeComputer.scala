package y2019.computer

class IntcodeComputer(programInput: Option[Int] = Option.empty, verbose:Boolean = false) {

  def execute(prog: Array[Int]): Int = {
    var instrPtr = 0
    var code: Array[Int] = prog
    var latestResult = -1
    while (code(instrPtr) != 99) {
      val(ptr, instr, res) = processInstructionAt((instrPtr, code))
      instrPtr = ptr
      code = instr
      latestResult = res
    }
    latestResult
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
      println("Output: " + result.get)
    else if (verbose) {
      if (result.isEmpty)
        println("Result is empty")
      else
        println("Result: " + result.get)
    }

    if (opcode == 4)
      (newPtr, instr, result.get)
    else if (result.isEmpty)
      (newPtr, instr, 0)
    else
      (newPtr + 1, storeResult(instr, newPtr, paraModeResult, result.get), result.get)
  }

  def addOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"AddOperation; ${getDigit(instr, ptr + 1, paraModeVar1) + getDigit(instr, ptr + 2, paraModeVar2)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1) + getDigit(instr, ptr + 2, paraModeVar2)), ptr+3)
  }
  def multiplyOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"MultiplyOperation; ${getDigit(instr, ptr + 1, paraModeVar1) * getDigit(instr, ptr + 2, paraModeVar2)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1) * getDigit(instr, ptr + 2, paraModeVar2)), ptr+3)
  }
  def requestInputOperation(ptr: Int): (Option[Int], Int) = {
    val input = readInput()
    println(f"Input: ${input.get}%d")
    (input, ptr+1)
  }
  def printOutputOperation(instr: Array[Int], ptr: Int, paraModeVar1: Int): (Option[Int], Int) = {
    if (verbose) println(f"Output; ${getDigit(instr, ptr + 1, paraModeVar1)}%d")
    (Option(getDigit(instr, ptr + 1, paraModeVar1)), ptr+2)
  }

  def jumpIfTrue(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"jumpIfTrue; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) != 0}%b")
    (Option.empty, if (getDigit(instr, ptr + 1, paraModeVar1) != 0) getDigit(instr, ptr + 2, paraModeVar2) else ptr + 3)
  }
  def jumpIfFalse(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"jumpIfFalse; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) == 0}%b")
    (Option.empty, if (getDigit(instr, ptr + 1, paraModeVar1) == 0) getDigit(instr, ptr + 2, paraModeVar2) else ptr + 3)
  }
  def lessThan(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"lessThan; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) < getDigit(instr, ptr + 2, paraModeVar2)}%b")
    (Option(if (getDigit(instr, ptr + 1, paraModeVar1) < getDigit(instr, ptr + 2, paraModeVar2)) 1 else 0), ptr + 3)
  }
  def equals(instr: Array[Int], ptr: Int, paraModeVar1: Int, paraModeVar2: Int): (Option[Int], Int) = {
    if (verbose) println(f"equals; ptr: $ptr%d, paramode1: $paraModeVar1%d, paramode2: $paraModeVar2%d, para1: ${getDigit(instr, ptr + 1, paraModeVar1)}%d, para2: ${getDigit(instr, ptr + 2, paraModeVar2)}%d, result: ${getDigit(instr, ptr + 1, paraModeVar1) == getDigit(instr, ptr + 2, paraModeVar2)}%b")
    (Option(if (getDigit(instr, ptr + 1, paraModeVar1) == getDigit(instr, ptr + 2, paraModeVar2)) 1 else 0), ptr + 3)
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

  def deconstructInstruction(instruction: Int):(Int, Int, Int, Int) = {
    (instruction % 100,
      (instruction / 100) % 10,
      (instruction / 1000) % 10,
      (instruction / 10000) % 10,
    )
  }

  def readInput():Option[Int] = {
    programInput
  }


}
