package y2017

object day04_2 {

  def main(args: Array[String]): Unit = {
    // Result 231
    val input = readInputStrings("y2017/day04_input.txt")
    println(f"Of the ${input.length}%d password in the input there are ${calculate(input)}%d valid passwords")
  }

  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def wordsDoNotContainSameLetters(str1: String, str2: String): Boolean = {
    str1.chars().sorted().toArray.zip(str2.chars().sorted().toArray).filter((z => z._1 == z._2)).length != str1.length
  }

  def isValid(pw: String): Boolean = {
    val words = pw.split(" ")
    var isValid = true
    for(i <- 0 to words.length - 2) {
      for(j <- i+1 to words.length - 1) {
        isValid = isValid && (words(i) != words(j))
        isValid = (if (isValid && (words(i).length == words(j).length)) wordsDoNotContainSameLetters(words(i), words(j)) else isValid)

      }
    }
    isValid
  }

  def calculate(strArr: Array[String]): Int = {
    strArr.filter(pw => isValid(pw)).length
  }

}
