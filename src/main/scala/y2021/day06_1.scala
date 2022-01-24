package y2021

object day06_1 {

  val daysToGo = 80

  def main(args: Array[String]): Unit = {
    // Result 359344
    val input = readInputStrings("y2021/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input, daysToGo)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def processInput(str: String): Array[(Int,Int)] = {
    val parts = str.split(",").map(p => p.toInt)
    parts.distinct.map(d => (d, parts.filter(p => p == d).length))
  }

  def determineOffspring(daysOld: Int, days2Go: Int): Int = {
    var fish = Array(daysOld)
    for(i <- 0 until days2Go) {
      var fish2Add = 0
      for(j <- 0 until fish.length) {
        fish(j) -= 1
        if (fish(j) < 0) {
          fish2Add += 1
          fish(j) = 6
        }
      }
      for(j <- 0 until fish2Add) fish = fish :+ 8
    }
    fish.length
  }

  def calculate(str: Array[String], numberOfDays: Int): Int = {
    val school:Array[(Int,Int)] = processInput(str(0))
    school.map(f => determineOffspring(f._1, numberOfDays) * f._2).sum
  }

}
