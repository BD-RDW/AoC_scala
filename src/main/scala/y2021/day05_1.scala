package y2021

object day05_1 {

  def main(args: Array[String]): Unit = {
    // Result 6548
    val input = readInputStrings("y2021/day05_input.txt")

    println(f"input contains ${input.length}%d lines, resulting in ${calculate(input)}%d overlapping points")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def procesInput(inputStr: Array[String]): Array[((Int, Int), (Int, Int))] = {
    inputStr.map(s => {
      val beginAndEnd = s.split("->")
      val begin = beginAndEnd(0).trim.split(",")
      val end = beginAndEnd(1).trim.split(",")
      ((begin(0).trim.toInt, begin(1).trim.toInt),(end(0).trim.toInt, end(1).trim.toInt))
    })
  }

  def addHorizontalLineToArea(area: Array[Array[Int]], y: Int, x1: Int, x2: Int): Array[Array[Int]] = {
    for(i <- x1.min(x2) to x1.max(x2)) {
      area(y)(i) += 1
    }
    area
  }
  def addVerticalLineToArea(area: Array[Array[Int]], x: Int, y1: Int, y2: Int): Array[Array[Int]] = {
    for(i <- y1.min(y2) to y1.max(y2)) {
      area(i)(x) += 1
    }
    area
  }

  def addLineToArea(area: Array[Array[Int]], begin: (Int, Int), end: (Int, Int)): Array[Array[Int]] = {
    if (begin._1 == end._1) addVerticalLineToArea(area, begin._1, begin._2, end._2) else addHorizontalLineToArea(area, begin._2, begin._1, end._1)
  }

  def processLines(lines: Array[((Int, Int), (Int, Int))]): Array[Array[Int]] = {
    val maxValue = lines.map(l => l._1._1.max(l._1._2).max(l._2._1).max(l._2._2)).max
    var area: Array[Array[Int]] = Array.fill(maxValue + 1, maxValue + 1)(0)
    lines.foreach(l => area = if (!(l._1._1 != l._2._1 && l._1._2 != l._2._2)) addLineToArea(area, l._1, l._2) else area)
    area
  }

  def calculate(str: Array[String]): Int = {
    val lines:Array[((Int,Int),(Int,Int))] = procesInput(str)
    val area = processLines(lines)
    area.flatMap(r => r).filter(s => s > 1).length
  }

}
