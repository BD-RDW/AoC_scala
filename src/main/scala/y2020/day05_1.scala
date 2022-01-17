package y2020

object day05_1 {

  def main(args: Array[String]): Unit = {
    // Result 906
    val input = readInputStrings("y2020/day05_input.txt")

    println(f"The seat information of ${input.length}%d pasenges results in ${calculate(input)}%d")
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
    str.map(i =>processSeatInformation(i)).reduceLeft(_ max _)
  }

}
