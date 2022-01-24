package y2015

object day06_1 {

  def main(args: Array[String]): Unit = {
    // Result 543903
    val input = readInputStrings("y2015/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def extractWhat2Do(instr: String):(String, (Int, Int), (Int, Int)) = {
    // turn on 0,0 through 999,999
    val instructionPattern = raw"(.*) (\d{1,3}),(\d{1,3}) through (\d{1,3}),(\d{1,3})".r
    instr.trim match {
      case instructionPattern(lights, x1, y1, x2, y2) => (lights, (x1.toInt, y1.toInt), (x2.toInt,y2.toInt))
    }
  }

  def getSwitchFunction(instr: String): Boolean => Boolean = {
    instr match {
      case "turn on" => (b: Boolean) => true
      case "turn off" => (b: Boolean) => false
      case "toggle" => (b: Boolean) => !b
    }
  }

  def switchLights(lightArr: Array[Array[Boolean]], begin: (Int, Int), end: (Int, Int), lightSwitch: Boolean => Boolean): Array[Array[Boolean]] = {
    for(i <- begin._1 to end._1) {
      for(j <- begin._2 to end._2) {
        lightArr(i)(j) = lightSwitch(lightArr(i)(j))
      }
    }
    lightArr
  }

  def processLightInstructions(lightArr: Array[Array[Boolean]], instr: String): Array[Array[Boolean]] = {
    val what2Do = extractWhat2Do(instr)
    switchLights(lightArr, what2Do._2, what2Do._3, getSwitchFunction(what2Do._1))
  }

  def calculate(strArr: Array[String]): Int = {
    var lightArr = Array.fill(1000,1000)(false)
    for (instr <- strArr) {
      lightArr = processLightInstructions(lightArr, instr)
    }
    lightArr.map(row => row.filter(e => e).length).sum
  }

}
