package y2020

object day05_2 {

  def main(args: Array[String]): Unit = {
    // Result 519
    val input = readInputStrings("y2020/day05_input.txt")

    println(f"After processing all seat information of ${input.length}%d passenges I found my seat at ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def decodeRow(str: String): Int = {
    Integer.parseInt(str.replaceAll("F", "0").replaceAll("B", "1"), 2)
  }

  def decodeChair(str: String): Int = {
    Integer.parseInt(str.replaceAll("L", "0").replaceAll("R", "1"), 2)
  }

  def processSeatInformation(str: String): Int = {
    (decodeRow(str.substring(0,7)) * 8) + decodeChair(str.substring(7))
  }

  def calculate(str: Array[String]): Int = {
    var seats: Array[Boolean] = Array.fill(127*8)(false)
    var mySeat = -1
    str.foreach(i => seats(processSeatInformation(i)) = true)
    for(i <- 1 until seats.length - 1) {
      if (!seats(i) && seats(i - 1) && seats(i + 1)) mySeat = i
    }
    mySeat
  }

}
