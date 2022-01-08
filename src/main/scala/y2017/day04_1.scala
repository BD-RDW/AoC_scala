package y2017

object day04_1 {

  def main(args: Array[String]): Unit = {
    // Result 337
    val input = readInputStrings("y2017/day04_input.txt")
    println(f"Of the ${input.length}%d password in the input there are ${calculate(input)}%d valid passwords")
  }

  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }


  def isValid(pw: String): Boolean = {
    val words = pw.split(" ")
    var isValid = true
    for(i <- 0 to words.length - 2) {
      for(j <- i+1 to words.length - 1) {
        isValid = isValid && (words(i) != words(j))
      }
    }
    isValid
  }

  def calculate(strArr: Array[String]): Int = {
    strArr.filter(pw => isValid(pw)).length
  }

}
