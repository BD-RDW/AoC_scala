package y2018

import scala.collection.mutable.ArrayBuffer

object day06_1 {

  def main(args: Array[String]): Unit = {
    // Result 4589
    val input = readInputStrings("y2018/day06_input.txt")

    println(f"input contains ${input.length}%d points, the lagest area is ${calculate(input)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def getClosestPoint(points: Array[((Int, Int), Int)], i: Int, j: Int): Char = {
    val dist = points.map(p => ((p._1._1 - i).abs + (p._1._2 - j).abs, p._2))
    val shortestDist = dist.map(p => p._1).min
    if (dist.filter(d => d._1 == shortestDist).length > 1)
      '.'
    else ('0' + dist.filter(d => d._1 == shortestDist)(0)._2).toChar
  }

  def fillArea(points: Array[((Int, Int),Int)]): Array[Array[Char]] = {
    val size = points.map(p => p._1._1).max.max(points.map(p => p._1._2).max) + 1
    val area = Array.fill(size, size)(' ')
    for(i <- 0 until size) {
      for(j <- 0 until size) {
        area(j)(i) = getClosestPoint(points, i, j)
      }
    }
    area
  }
  def processInput(strArr: Array[String]): Array[((Int, Int),Int)] = {
    strArr.map(s => s.trim.split(",")).map(n => (n(0).trim.toInt, n(1).trim.toInt)).zipWithIndex
  }

  def determineFiniteAreas(area: Array[Array[Char]], numOfPoints: Int): Array[Char] = {
    var finiteAreas:ArrayBuffer[Char] = ArrayBuffer.fill(numOfPoints)('.')
    for(i <- 0 until numOfPoints) {
      finiteAreas(i) = ('0' + i).toChar
    }
    for(i <- 0 until area.length) {
      finiteAreas = (if (finiteAreas.contains(area(i)(0))) finiteAreas -= area(i)(0) else finiteAreas)
      finiteAreas = (if (finiteAreas.contains(area(0)(i))) finiteAreas -= area(0)(i) else finiteAreas)
      finiteAreas = (if (finiteAreas.contains(area(i)(area.length-1))) finiteAreas -= area(i)(area.length-1) else finiteAreas)
      finiteAreas = (if (finiteAreas.contains(area(area.length-1)(i))) finiteAreas -= area(area.length-1)(i) else finiteAreas)
    }
    finiteAreas.toArray
  }

  def getLargestEnclosedAreaSize(area: Array[Array[Char]], numOfPoints:Int): Int = {
    val finiteAreas = determineFiniteAreas(area, numOfPoints)
    var maxSize = -1
    finiteAreas.foreach(fa => maxSize = maxSize.max(area.flatten.filter(ac => ac == fa).length))
    maxSize
  }

  def calculate(strArr: Array[String]): Int = {
    val points = processInput(strArr)
    val area = fillArea(points)
    getLargestEnclosedAreaSize(area, points.length)
  }

}
