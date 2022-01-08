package y2016

object day04_2 {

  def main(args: Array[String]): Unit = {
    // Result 245102
    val input = readInputString("y2016/day04_input.txt")
    println(f"The input of ${input.length}%d room ids results in ${calculate(input)}%d")
  }

  def readInputString(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def isRealRoom(r: roomId): Boolean = {
    var chrs: List[charCount] = List()
    for(i <- 0 to r.name.length - 1) {
      if (r.name.charAt(i) != '-') {
        val listElement = chrs.filter(c => c.chr == r.name.charAt(i))
        if (listElement.length == 0) {
          chrs = charCount(r.name.charAt(i), 1) +: chrs
        } else {
          val charCnt = listElement(0)
          chrs = chrs.filter(c => c.chr != r.name.charAt(i)) :+ charCount(charCnt.chr, charCnt.cnt + 1)
        }
      }
    }
    val orderedChrs = chrs.sortWith((c1,c2) => if (c1.cnt == c2.cnt) c1.chr < c2.chr else c1.cnt > c2.cnt)
    if (orderedChrs.length >= r.checksum.length) {
      var checksumOk = true
      for(i <- 0 to r.checksum.length - 1) {
        checksumOk = checksumOk && orderedChrs(i).chr == r.checksum.charAt(i)
      }
      checksumOk
    } else false
  }

  def mapToRoomId(s: String): roomId = {
    val parser = raw"^([a-z0-9-]+)-([0-9]+)\[([a-z]{5})\]".r("id","sector","checksum")
    val result = parser.findFirstMatchIn(s)
    if (result.isDefined) {
      val regex = result.get
      roomId(regex.group("id"), regex.group("sector").toInt, regex.group("checksum"))
    } else null
  }

  def decodeRoomname(r: roomId): roomId = {
    var newRoomId = ""
    for(i <- 0 to r.name.length - 1) {
      val shift = r.sector % 26
      newRoomId += (if (r.name.charAt(i) != '-') (((r.name.charAt(i).toInt - 'a'.toInt + shift) % 26) + 'a').toChar else ' ')
    }
    roomId(newRoomId, r.sector, r.checksum)
  }

  def calculate(strArr: Array[String]): Int = {
    strArr.map(s => mapToRoomId(s)).filter(r => isRealRoom(r)).map(r => decodeRoomname(r)).filter(r => r.name.toUpperCase.startsWith("NORTHPOLE"))(0).sector
  }

  case class roomId(name:String, sector: Int, checksum: String)
  case class charCount(chr:Char, cnt: Int)
}
