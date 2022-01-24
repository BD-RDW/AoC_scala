package y2017

object day06_1 {

  // Result 6681
  val input = "4\t1\t15\t12\t0\t9\t9\t5\t5\t8\t7\t3\t14\t5\t12\t3"
  def main(args: Array[String]): Unit = {
    println(f"After ${calculate(input)}%d loops over the ${input.split("\t").length}%d memory buffers the situation is seen again")
  }

  def getMemoryBankToRedistribute(memoryBlockCnt: Array[Int]): Int = {
    var bankNum = -1
    val blockCnt = memoryBlockCnt.max
    for (i <- 0 until memoryBlockCnt.length) {
      bankNum = (if (bankNum == -1 && memoryBlockCnt(i) == blockCnt) i else bankNum)
    }
    bankNum
  }

  def redistributeBlocks(memoryBlockCnt: Array[Int]): Array[Int] = {
    val memoryBankToClearOut = getMemoryBankToRedistribute(memoryBlockCnt)
    var numOfBlocks = memoryBlockCnt(memoryBankToClearOut)
    memoryBlockCnt(memoryBankToClearOut) = 0
    for(i <- 1 to numOfBlocks) {
      val index = (memoryBankToClearOut + i) % memoryBlockCnt.length
      memoryBlockCnt(index) = memoryBlockCnt(index) + 1
    }
   memoryBlockCnt
  }

  def calculate(str: String): Int = {
    var memoryBlockCnt = str.split("\t").map(s => s.toInt)
    var memorySituations: Array[String] = Array()
    var checkStr = memoryBlockCnt.mkString(",")
    var loopCnt = 0
    while (! memorySituations.contains(checkStr)) {
      memorySituations = memorySituations :+ checkStr
      loopCnt += 1
      memoryBlockCnt = redistributeBlocks(memoryBlockCnt)
      checkStr = memoryBlockCnt.mkString(",")
    }
    loopCnt
  }
}
