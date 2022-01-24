package y2020

object day06_2 {

  def main(args: Array[String]): Unit = {
    // Result 3585
    val input = readInputStrings("y2020/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def processInput(strArr: Array[String]): Array[Array[String]] = {
    var groupArray:Array[String] = Array()
    var allResults:Array[Array[String]] = Array()
    strArr.foreach(r => if (r.trim.length == 0) {
      allResults = allResults :+ groupArray
      groupArray = Array()
    } else {
      groupArray = groupArray :+ r
    })
    if (!groupArray.isEmpty) {
      allResults = allResults :+ groupArray
    }
    allResults
  }

  def determineCount(arr: Array[String]): Int = {
    val length = arr.length
    var cnt = 0
    var previousChar:Char = 0
    var tempCnt = 1
    arr.flatten.sorted.foreach(c => if (c == previousChar) {
      tempCnt += 1
    } else {
      if (tempCnt == length && previousChar != 0) { cnt += 1 }
      previousChar = c
      tempCnt = 1
    })
    if (tempCnt == length && previousChar != 0) { cnt += 1 }
    cnt
  }

  def countQuestions(allResults: Array[Array[String]]): Int = {
    allResults.map(r => determineCount(r)).sum
  }

  def calculate(strArr: Array[String]): Int = {
    val allResults:Array[Array[String]] = processInput(strArr)
    countQuestions(allResults)
  }

}
