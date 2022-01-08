package y2019

import scala.util.Sorting

object day02_1 {

  // Result 2782414
  val input = Array(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,1,6,19,23,1,23,13,27,2,6,27,31,1,5,31,35,2,10,35,39,1,6,39,43,1,13,43,47,2,47,6,51,1,51,5,55,1,55,6,59,2,59,10,63,1,63,6,67,2,67,10,71,1,71,9,75,2,75,10,79,1,79,5,83,2,10,83,87,1,87,6,91,2,9,91,95,1,95,5,99,1,5,99,103,1,103,10,107,1,9,107,111,1,6,111,115,1,115,5,119,1,10,119,123,2,6,123,127,2,127,6,131,1,131,2,135,1,10,135,0,99,2,0,14,0)

  def main(args: Array[String]): Unit = {
    input(1) = 12
    input(2) = 2
    println(f"The program input of ${input.length}%d instructions results in ${execute(input)}%d")
  }

  def processInstructionAt(tpl: (Int, Array[Int])): (Int, Array[Int]) = {
    var result:Int = 0
    val(ptr, instr) = tpl
    instr(ptr) match {
      case 1 => result = instr(instr(ptr + 1)) + instr(instr(ptr + 2))
      case 2 => result = instr(instr(ptr + 1)) * instr(instr(ptr + 2))
    }
    println ("Ptr: " + ptr + "; Result " + result + " is place at " + instr(ptr + 3))
    instr(instr(ptr + 3)) = result
    (ptr + 4, instr)
  }

  def execute(prog: Array[Int]): Int = {
    var instrPtr = 0
    var code: Array[Int] = prog
    while (code(instrPtr) != 99) {
      val(ptr, instr) = processInstructionAt((instrPtr, code))
      instrPtr = ptr
      code = instr
    }
    code(0)
  }

}