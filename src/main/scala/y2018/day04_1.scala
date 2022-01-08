package y2018

object day04_1 {

  def main(args: Array[String]): Unit = {
    // Result 39422
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

  def getGuardMostlySleeping(sleepInfo: List[(Int, Int)]): Int = {
    var name:String = null
    val tempMap = sleepInfo.groupBy(_._1)
    var tempList:List[(Int,Int)] = List()
    tempMap.keys.foreach(k => {
      tempList = tempList :+ (k, tempMap.get(k).get.map(st => st._2).sum)
    })

    tempList.sortBy(stI => stI._2).reverse.head._1
  }


  def calculate(strArr: Array[String]): Int = {
    val sleepTime = processLines(strArr)
    val sleepInfo = sleepTime.map(r => (r._1, r._3 - r._2))
    val sleepyGuard = getGuardMostlySleeping(sleepInfo)
    var minutes = Array.fill[Int](60)(0)
    sleepTime.filter(st => st._1 == sleepyGuard).foreach( st => for(i <- st._2 to st._3 - 1) minutes(i) += 1)
    var minute = 0
    var value = 0
    for(i <- 0 to 59) {
      if (value < minutes(i)) {
        value = minutes(i)
        minute = i
      }
    }
    minute * sleepyGuard
  }
  case class sleepTime(name:String, times: List[(Int,Int)])
}
