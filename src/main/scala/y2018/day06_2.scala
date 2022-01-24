package y2018

object day06_2 {

  def main(args: Array[String]): Unit = {
    // Result 40252
    val input = readInputStrings("y2018/day06_input.txt")

    println(f"input contains ${input.length}%d points, the area size is ${calculate(input, 10000)}%d")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def getDistanceIndicator(points: Array[((Int, Int), Int)], i: Int, j: Int, maxDistance: Int): Char = {
    var dist = 0
    points.map(p => ((p._1._1 - i).abs + (p._1._2 - j).abs, p._2)).foreach( dist += _._1)
    if (dist < maxDistance)
      '#'
    else ' '
  }

  def fillArea(points: Array[((Int, Int),Int)], maxTotalDistance: Int): Array[Array[Char]] = {
    val size = points.map(p => p._1._1).max.max(points.map(p => p._1._2).max) + 1
    val area = Array.fill(size, size)(' ')
    for(i <- 0 until size) {
      for(j <- 0 until size) {
        area(j)(i) = getDistanceIndicator(points, i, j, maxTotalDistance)
      }
    }
    area
  }
  def processInput(strArr: Array[String]): Array[((Int, Int),Int)] = {
    strArr.map(s => s.trim.split(",")).map(n => (n(0).trim.toInt, n(1).trim.toInt)).zipWithIndex
  }

  def getAreaSize(area: Array[Array[Char]], numOfPoints:Int): Int = {
    area.flatten.filter(ac => ac == '#').length
  }

  def calculate(strArr: Array[String], maxTotalDistance: Int): Int = {
    val points = processInput(strArr)
    val area = fillArea(points, maxTotalDistance)
    getAreaSize(area, points.length)
  }

}
