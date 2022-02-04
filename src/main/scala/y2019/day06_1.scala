package y2019

object day06_1 {

  def main(args: Array[String]): Unit = {
    // Result 308790
    val input = readInputStrings("y2019/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def procesInput(strArr: Array[String]): Array[(String,String)] = {
    strArr.map(s => s.split("\\)")).map(a => (a(0),a(1)))
  }

  def getNumberOfOrbits(spaceBodies: Array[(String, String)], leave: String): Int = {
    val body = spaceBodies.filter(sb => sb._2 == leave)
    if (body.length == 0) {println(f"Seems that $leave%s is not a leave")}
    if (body.length > 1) {println(f"Seems that leave $leave%s has more then 1 branch")}
    if (body(0)._1 == "COM") 1 else 1+ getNumberOfOrbits(spaceBodies, body(0)._1)
  }

  def determineNumberOfOrbits(spaceBodies: Array[(String, String)], leaves: Array[String]): Int = {
    var cnt = 0
    leaves.foreach(l => {
      cnt += getNumberOfOrbits(spaceBodies, l)
    })
    cnt
  }

  def calculate(strArr: Array[String]): Int = {
    val spaceBodies = procesInput(strArr)
    val leaves = spaceBodies.map(sb => sb._2).distinct
    determineNumberOfOrbits(spaceBodies, leaves)
  }

}
