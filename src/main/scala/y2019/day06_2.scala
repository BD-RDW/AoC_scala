package y2019

object day06_2 {

  def main(args: Array[String]): Unit = {
    // Result 472
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

  def getPathFor(spaceBodies: Array[(String, String)], name: String): Array[String] = {
    val node = spaceBodies.filter(sb => sb._2 == name)
    if (node(0)._1 == "COM") Array("COM") else getPathFor(spaceBodies, node(0)._1) :+ node(0)._1
  }

  def calculate(strArr: Array[String]): Int = {
    val spaceBodies = procesInput(strArr)
    val youTree = getPathFor(spaceBodies, "YOU")
    val sanTree = getPathFor(spaceBodies, "SAN")
    youTree.length + sanTree.length - (2 * youTree.zip(sanTree).filter(z => z._1 == z._2).length)
  }
  // 7 + 5 - (2 * 3)

}
//class SpaceBody {
//  val name: String
//
//}