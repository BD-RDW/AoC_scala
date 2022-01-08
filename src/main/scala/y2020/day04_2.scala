package y2020

object day04_2 {

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

  def byrIsvalid(byr: String): Boolean = {
    !byr.isEmpty && byr.toInt >= 1920 && byr.toInt <= 2002
  }

  def iyrIsvalid(iyr: String): Boolean = {
    !iyr.isEmpty && iyr.toInt >= 2010 && iyr.toInt <= 2020
  }

  def eyrIsvalid(eyr: String): Boolean = {
    !eyr.isEmpty && eyr.toInt >= 2020 && eyr.toInt <= 2030
  }

  def hgtIsvalid(hgt: String): Boolean = {
    var isValid = !hgt.isEmpty
    isValid = isValid && (hgt.endsWith("cm") || hgt.endsWith("in"))
    if (isValid) {
      val measurement = hgt.substring(0, hgt.length - 2).toInt
      isValid = isValid && (if (hgt.endsWith("cm")) measurement >= 150 && measurement <= 193 else measurement >= 59 && measurement <= 76)
    }
    isValid
  }

  def hclIsvalid(hcl: String): Boolean = {
    !hcl.isEmpty && hcl.startsWith("#") && hcl.length == 7 && hcl.substring(1).filter(c => (c >= '0' && c <= '9') || c >= 'a' && c <= 'f').length == 6
  }

  def eclIsvalid(ecl: String): Boolean = {
    !ecl.isEmpty && ecl.length == 3 && (ecl == "amb" || ecl == "blu" || ecl == "brn" || ecl == "gry" || ecl == "grn" || ecl == "hzl" || ecl == "oth")
  }

  def pidIsvalid(pid: String): Boolean = {
    !pid.isEmpty && pid.length == 9 && pid.filter(c => (c >= '0' && c <= '9')).length == 9
  }

  def isValid(p: passport): Boolean = {
    (byrIsvalid(p.byr) && iyrIsvalid(p.iyr) && eyrIsvalid(p.eyr) && hgtIsvalid(p.hgt) && hclIsvalid(p.hcl) && eclIsvalid(p.ecl) && pidIsvalid(p.pid))
  }

  def calculate(str: Array[String]): Int = {
    var passportInfo:Array[String] = processInput(str)
    passports = buildPassports(passportInfo)
    passports.filter(p => isValid(p)).length
  }

  case class passport(byr:String, iyr:String, eyr:String, hgt:String, hcl:String, ecl:String, pid:String, cid:String)
}
