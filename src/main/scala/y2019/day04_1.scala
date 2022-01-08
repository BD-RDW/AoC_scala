package y2019

object day04_1 {

  // Result 1660
  val input = (172851,675869)

  def main(args: Array[String]): Unit = {
    println(f"of the input range ${input._1}%d to ${input._2}%d there are ${calculate(input)}%d possible passwords")
  }

  def pwContainsTwoAdjacentSameDigits(pwAsString: String): Boolean = {
    var sameDigitsFound = false
    for(i <- 0 to pwAsString.length - 2) {
      sameDigitsFound = sameDigitsFound || pwAsString.charAt(i) == pwAsString.charAt(i + 1)
    }
    sameDigitsFound
  }

  def pwDigitsNeverDecrease(pwAsString: String): Boolean = {
    var digitsNeverDecrease = true
    for(i <- 0 to pwAsString.length - 2) {
      digitsNeverDecrease = digitsNeverDecrease && pwAsString.charAt(i) <= pwAsString.charAt(i + 1)
    }
    digitsNeverDecrease
  }

  def isValidPassword(i: Int): Boolean = {
    val pwAsString = i.toString
    var pwIsValid = pwAsString.length == 6
    pwIsValid = pwIsValid && pwContainsTwoAdjacentSameDigits(pwAsString)
    pwIsValid = pwIsValid && pwDigitsNeverDecrease(pwAsString)
    pwIsValid
  }

  def calculate(range: (Int, Int)): Int = {
    var cnt = 0
    for(i <- range._1 to range._2) cnt += (if (isValidPassword(i)) 1 else 0)
    cnt
  }

}
