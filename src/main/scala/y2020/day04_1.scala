package y2020

object day04_1 {

  // Result ?????
  val input = readInputStrings("y2020/day04_input.txt")
  var passports: Array[passport] = Array()

  def main(args: Array[String]): Unit = {
    println(f"Of the input lines (${input.length}%d) there are ${calculate(input)}%d valid passports of a total of ${passports.length}%d passports")
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }

  def processInput(input: Array[String]): Array[String] = {
    var strings: Array[String] = Array()
    var tempString:String = ""
    input.foreach(i => if (i.isEmpty) {
      strings = strings :+ tempString
      tempString = ""
    } else {
      tempString = tempString + " " + i
    })
    strings :+ tempString
  }

  def getStringpart(info: String, partId: String): String = {
    var checkString = info + " "
    if (checkString.indexOf(partId) >= 0)
      checkString.substring(checkString.indexOf(partId)+partId.length + 1, checkString.indexOf(" ", checkString.indexOf(partId)+partId.length + 1))
    else ""
  }

  def buildPassports(passportInfo: Array[String]): Array[passport] = {
    var pp: Array[passport] = Array()
    passportInfo.foreach(pi => {
      pp = pp :+ passport(
        getStringpart(pi, "byr"),
        getStringpart(pi, "iyr"),
        getStringpart(pi, "eyr"),
        getStringpart(pi, "hgt"),
        getStringpart(pi, "hcl"),
        getStringpart(pi, "ecl"),
        getStringpart(pi, "pid"),
        getStringpart(pi, "cid")
      )
    })
    pp
  }

  def isValid(p: passport): Boolean = {
    ! (p.byr.isEmpty || p.iyr.isEmpty || p.eyr.isEmpty || p.hgt.isEmpty || p.hcl.isEmpty || p.ecl.isEmpty|| p.pid.isEmpty)
  }

  def calculate(str: Array[String]): Int = {
    var passportInfo:Array[String] = processInput(str)
    passports = buildPassports(passportInfo)
    passports.filter(p => isValid(p)).length
  }

  case class passport(byr:String, iyr:String, eyr:String, hgt:String, hcl:String, ecl:String, pid:String, cid:String)
}
