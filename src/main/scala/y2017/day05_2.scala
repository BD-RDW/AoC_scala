package y2017

object day05_2 {

  def main(args: Array[String]): Unit = {
    // Result 21985262
    val input = readInputStrings("y2017/day05_input.txt")

    println(f"There are ${input.length}%d jump instructions, but after ${calculateNumberOfStepsNeededToEscapeTheMaze(input)}%d the cpu is out of the maze")
  }


  def readInputStrings(filename: String):Array[Int] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray.map(str => str.toInt) finally source.close()
  }

  def moveToNextInstruction(instructions: Array[Int], index: Int): (Array[Int], Int) = {
    val nextIndex = index + instructions(index)
    val instr = instructions.updated(index, instructions(index) + (if (instructions(index) < 3) 1 else -1))
    (instr, nextIndex)
  }

  def calculateNumberOfStepsNeededToEscapeTheMaze(arr: Array[Int]): Int = {
    var stepCntr = 0
    var index = 0
    var localArray = arr.clone()
    while (index < arr.length) {
      val result = moveToNextInstruction(localArray, index)
      stepCntr += 1
      localArray = result._1
      index = result._2
    }
    stepCntr
  }

}
