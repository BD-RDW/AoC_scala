package y2021

object day06_2 {

  val daysToGo = 256

  def main(args: Array[String]): Unit = {
    // Result 1629570219571
    val input = readInputStrings("y2021/day06_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input, daysToGo)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def processInput(str: String): Array[(Int,Long)] = {
    val parts = str.split(",").map(p => p.toInt)
    parts.distinct.sorted.map(d => (d, parts.filter(p => p == d).length))
  }

  def determineOffspring(daysOld: Int, days2Go: Int): Array[(Int,Long)] = {
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
    fish.distinct.sorted.map(d => (d, fish.filter(p => p == d).length))
  }

  def determineOffspringForSchool(school: Array[(Int, Long)], interval: Int): Array[(Int, Long)] = {
    var totalSchool: Array[(Int, Long)] = Array()
    for(i <- 0 until school.length) {
      totalSchool = determineOffspring(school(i)._1, interval).map(f => (f._1, f._2 * school(i)._2)) ++ totalSchool
    }
    totalSchool.map(s => s._1).distinct.sorted.map(d => (d, totalSchool.filter(p => p._1 == d).map(t => t._2).sum))
  }

  def calculate(str: Array[String], numberOfDays: Int): Long = {
    var school:Array[(Int,Long)] = processInput(str(0))
    var dayCnt = numberOfDays
    var interval = (if (dayCnt > 50) 50 else dayCnt)
    while (interval > 0) {
      school = determineOffspringForSchool(school, interval)
      dayCnt -= 50
      interval = (if (dayCnt > 50) 50 else dayCnt)
    }
    school.map(f => f._2).sum
  }

}
