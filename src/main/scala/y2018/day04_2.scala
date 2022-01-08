package y2018

object day04_2 {

  def main(args: Array[String]): Unit = {
    // Result 65474
    val input = readInputStrings("y2018/day04_input.txt")
    println(f"input ${input.length}%s results in ${calculate(input)}%d")
  }

  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def extractData(rec: String) = {
    val parser = raw"([0-9-]{2}):([0-9-]{2})\] (.*+)".r("hours","minutes","message")
    val result = parser.findFirstMatchIn(rec)
    if (result.isDefined) {
      val regex = result.get
      (regex.group("hours").toInt, regex.group("minutes").toInt, regex.group("message"))
    } else null  }

  def getGuardId(message: String): Int = {
    message.substring(message.indexOf("#") + 1, message.indexOf(" ", message.indexOf("#"))).toInt
  }

  def processLines(strArr: Array[String]): List[(Int, Int, Int)] = {
    var sleepInfo: List[(Int, Int, Int)] = List()
    var id: Int = -1
    var startTime:Int = -100

    strArr.sorted.foreach( rec => {
      val (hours, minutes, message) = extractData(rec)
      if (message.contains("begins shift")) {
        id = getGuardId(message)
      } else if (message.contains("falls asleep")) {
        startTime = (if (hours == 0) minutes else minutes - 60)
      } else if (message.contains("wakes up")) {
        sleepInfo = sleepInfo :+ ( id, startTime, minutes)
      } else println(f"Unknown message: $message%s")
    })
    sleepInfo
  }

  def prepareMap(sleepTime: List[(Int, Int, Int)]): Map[Int,Array[Int]] = {
    var map: Map[Int,Array[Int]] = Map()
    sleepTime.map(st => st._1).distinct.foreach(g => map = map + (g -> Array.fill[Int](60)(0)))
    map
  }

  def getMinutesAsleepPerGuard(sleepTime: List[(Int, Int, Int)]): Map[Int,Array[Int]] = {
    val sleeptimePerGuard = prepareMap(sleepTime)
    sleepTime.groupBy(st => st._1).foreach(g => g._2.foreach(st => {
      for(i <- st._2 to st._3 - 1) {
        sleeptimePerGuard.get(g._1).get(i) += 1
      }
    }))
    sleeptimePerGuard
  }

  def getMinuteMostAsleepForGuard(sleeptimes: Array[Int]): (Int,Int) = {
    var minute = -1
    var cnt = -1
    for(i <- 0 to sleeptimes.length - 1) {
      if (sleeptimes(i) > cnt) {
        cnt = sleeptimes(i)
        minute = i
      }
    }
    (cnt,minute)
  }

  def getMinuteMostAsleep(sleepTimePerGuard: Map[Int, Array[Int]]):(Int,Int) = {
    var guard = -1
    var minute = -1
    var timesAsleep = -1
    sleepTimePerGuard.keys.foreach(g => {
      val (value, minuteMostAsleep) = getMinuteMostAsleepForGuard(sleepTimePerGuard.get(g).get)
      if (value > timesAsleep) {
        guard = g
        minute = minuteMostAsleep
        timesAsleep = value
      }
    })

    (guard, minute)
  }

  def calculate(strArr: Array[String]): Int = {
    val sleepTime = processLines(strArr)
    val sleepTimePerGuard = getMinutesAsleepPerGuard(sleepTime)
    val(guard:Int, minute:Int) = getMinuteMostAsleep(sleepTimePerGuard)
    minute * guard
  }
  case class sleepTime(name:String, times: List[(Int,Int)])
}
