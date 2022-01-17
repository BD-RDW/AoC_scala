package y2015

object day05_2 {

  def main(args: Array[String]): Unit = {
    // Result 53
    val input = readInputStrings("y2015/day05_input.txt")
    println(f"Van de ${input.length}%d strings there are ${calculate(input)}%d nice ones")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def aPairOfLettersAppearTwice(str: String): Boolean = {
    var stringIsOk = false
    for(i <- 0 until str.length - 3) {
      stringIsOk = stringIsOk || str.substring(i+2).contains(str.substring(i, i+2))
    }
    stringIsOk
  }

  def hasRepeatingCharacterWithOneCharacterInBetween(str: String): Boolean = {
    var stringIsOk = false
    for(i <- 0 until str.length - 2) {
      stringIsOk = stringIsOk || str.charAt(i) == str.charAt(i+2)
    }
    stringIsOk
  }

  def calculate(strArr: Array[String]): Int = {
    var cnt = 0
    for(str <- strArr) {
      cnt += (if ((aPairOfLettersAppearTwice(str) && hasRepeatingCharacterWithOneCharacterInBetween(str))) 1 else 0)
    }
    cnt
  }

}
