package y2016

object day06_2 {

  def main(args: Array[String]): Unit = {
    // Result afwlyyyq
    val input = readInputStrings("y2016/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in the message ${calculate(input)}%s")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def getLeastUsedCharacter(strArr: Array[String], cnt: Int): Char = {
    val chrArr = Array.fill(128)(0)
    for (elem <- strArr) {
      chrArr(elem.charAt(cnt)) += 1
    }
    var chr = 0
    var chrCnt = Int.MaxValue
    for(i <- 0 until chrArr.length) {
      if (chrArr(i) > 0 && chrCnt > chrArr(i)) {
        chr = i
        chrCnt = chrArr(i)
      }
    }
    chr.toChar
  }

  def calculate(strArr: Array[String]): String = {
    var message = ""
    for(cnt <- 0 until strArr(0).length) {
      message = message + getLeastUsedCharacter(strArr, cnt)
    }
    message
  }

}
