package y2020

object day06_1 {

  def main(args: Array[String]): Unit = {
    // Result 6930
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

  def countQuestions(allResults: Array[Array[String]]): Int = {
    allResults.map(r => r.flatten.distinct.length).sum
  }

  def calculate(strArr: Array[String]): Int = {
    val allResults:Array[Array[String]] = processInput(strArr)
    countQuestions(allResults)
  }

}
