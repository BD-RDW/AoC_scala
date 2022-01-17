object dayxx_1 {

  def main(args: Array[String]): Unit = {
    // Result ?????
    val input = readInputStrings("dayxx_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }
  def calculate(str: Array[String]): Int = {
    -1
  }

}
