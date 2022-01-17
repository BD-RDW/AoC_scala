package y2015

object day05_1 {

  def main(args: Array[String]): Unit = {
    // Result 258
    val input = readInputStrings("y2015/day05_input.txt")
    println(f"Van de ${input.length}%d strings there are ${calculate(input)}%d nice ones")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def containsThreeVowels(str: String): Boolean = {
    val vowel:Array[Char] = Array('a','e','i','o','u')
    str.toCharArray.filter(c => vowel.contains(c)).length > 2
  }

  def containsALetterAppearingTwice(str: String): Boolean = {
    var characterAppearingTwice = false
    for(i <- 0 until str.length - 1) {
      characterAppearingTwice = characterAppearingTwice || str.charAt(i) == str.charAt(i+1)
    }
    characterAppearingTwice
  }

  def notContainingCertainStrings(str: String): Boolean = {
    val stringNotAllowed = Array("ab", "cd", "pq", "xy")
    var stringIsOk = true
    for(s <- stringNotAllowed) {
      stringIsOk = stringIsOk && (! str.contains(s))
    }
    stringIsOk
  }

  def calculate(strArr: Array[String]): Int = {
    var cnt = 0
    for(str <- strArr) {
      cnt += (if ((containsThreeVowels(str) && containsALetterAppearingTwice(str) && notContainingCertainStrings(str))) 1 else 0)
    }
    cnt
  }

}
