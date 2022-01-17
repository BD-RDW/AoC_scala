package y2018

object day05_2 {

  val diffCaps = 'a' - 'A'

  def main(args: Array[String]): Unit = {
    // Result 4098
    val input = readInputStrings("y2018/day05_input.txt")(0)
    println(f"input ${input.substring(0,20)}%s results in ${calculate(input)}%d")
  }

  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def determineDistinctUnits(str: String): Array[Char] = {
    str.toUpperCase.toCharArray.distinct.sorted
  }

  def removeUnitsFromString(str: String, chr: Char): String = {
    str.toCharArray.filter(c => c != chr && c != chr + diffCaps).mkString
  }

  def processReactions(str: String): (String, Boolean) = {
    var reactionsOccured = false
    var strAfterReactions = str
    var chrCnt = 0
    while (chrCnt < strAfterReactions.length - 1) {
      if ( (strAfterReactions.charAt(chrCnt) == strAfterReactions.charAt(chrCnt+1) + diffCaps) ||
        (strAfterReactions.charAt(chrCnt) + diffCaps == strAfterReactions.charAt(chrCnt+1)) ) {
        reactionsOccured = true
        strAfterReactions = (if (chrCnt > 0) strAfterReactions.substring(0,chrCnt) else "") +
          (if (chrCnt < strAfterReactions.length - 2) strAfterReactions.substring(chrCnt+2) else "")
      }
      chrCnt += 1
    }
    (strAfterReactions, reactionsOccured)
  }

  def determineStringLengthAfterReactions(str: String): Int = {
    var tryAgain = true
    var myStr = str
    while (tryAgain) {
      val res = processReactions(myStr)
      myStr = res._1
      tryAgain = res._2
    }
    myStr.length
  }

  def calculate(str: String): Int = {
    var minLength = str.length
    for( c <- determineDistinctUnits(str)) {
      minLength = minLength.min(determineStringLengthAfterReactions(removeUnitsFromString(str, c)))
    }
    minLength
  }

}
