package y2020

import org.scalatest.FunSuite
import y2020.day04_2._

class day04_2Test  extends FunSuite {

  val input1 = Array(
    "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
    "byr:1937 iyr:2017 cid:147 hgt:183cm",
    "",
    "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
    "hcl:#cfa07d byr:1929",
    "",
    "hcl:#ae17e1 iyr:2013",
    "eyr:2024",
    "ecl:brn pid:760753108 byr:1931",
    "hgt:179cm",
    "",
    "hcl:#cfa07d eyr:2025 pid:166559648",
    "iyr:2011 ecl:brn hgt:59in"
  )
  val input2 = Array(
    "eyr:1972 cid:100",
    "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
    "",
    "iyr:2019",
    "hcl:#602927 eyr:1967 hgt:170cm",
    "ecl:grn pid:012533040 byr:1946",
    "",
    "hcl:dab227 iyr:2012",
    "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
    "",
    "hgt:59cm ecl:zzz",
    "eyr:2038 hcl:74454a iyr:2023",
    "pid:3556412378 byr:2007",
    "",
    "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
    "hcl:#623a2f",
    "",
    "eyr:2029 ecl:blu cid:129 byr:1989",
    "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
    "",
    "hcl:#888785",
    "hgt:164cm byr:2001 iyr:2015 cid:88",
    "pid:545766238 ecl:hzl",
    "eyr:2022",
    "",
    "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
  )
  val checkArray = Array(
    passport("1937","2017","2020","183cm","#fffffd","gry","860033327","147"),
    passport("1929","2013","2023",""     ,"#cfa07d","amb","028048884","350"),
    passport("1931","2013","2024","179cm","#ae17e1","brn","760753108",""),
    passport(""    ,"2011","2025","59in" ,"#cfa07d","brn","166559648","")
  )

  test("Determine ...") {
    assert(calculate(input2) == 4)
  }

  test("Processing input to strings") {
    val strings = processInput(input1)
    assert(strings.length == 4)
  }
  test("Processing input to passports") {
    val strings = processInput(input1)
    assert(buildPassports(strings).length == 4)
    assert(buildPassports(strings).zip(checkArray).filter(z => z._1 != z._2).length == 0)
  }
  test("Checking if passports are valid") {
    assert(isValid(passport("1937","2017","2020","183cm","#fffffd","gry","860033327","147")))
    assert(!isValid(passport("1929","2013","2023",""     ,"#cfa07d","amb","028048884","350")))
    assert(isValid(passport("1931","2013","2024","179cm","#ae17e1","brn","760753108","")))
    assert(!isValid(passport(""    ,"2011","2025","59in" ,"#cfa07d","brn","166559648","")))
  }
  test("checking byr valid") {
    assert(!byrIsvalid(""))
    assert(!byrIsvalid("1919"))
    assert(byrIsvalid("1920"))
    assert(byrIsvalid("2002"))
    assert(!byrIsvalid("2003"))
    assert(byrIsvalid("2000"))
  }
  test("checking iyr valid") {
    assert(!iyrIsvalid(""))
    assert(!iyrIsvalid("2009"))
    assert(iyrIsvalid("2010"))
    assert(iyrIsvalid("2020"))
    assert(!iyrIsvalid("2021"))
    assert(iyrIsvalid("2015"))
  }
  test("checking eyr valid") {
    assert(!eyrIsvalid(""))
    assert(!eyrIsvalid("2019"))
    assert(eyrIsvalid("2020"))
    assert(eyrIsvalid("2030"))
    assert(!eyrIsvalid("2031"))
    assert(eyrIsvalid("2025"))
  }
  test("checking hgt valid") {
    assert(!hgtIsvalid(""))
    assert(!hgtIsvalid("149cm"))
    assert(hgtIsvalid("150cm"))
    assert(hgtIsvalid("193cm"))
    assert(!hgtIsvalid("194cm"))
    assert(hgtIsvalid("165cm"))
    assert(!hgtIsvalid("58in"))
    assert(hgtIsvalid("59in"))
    assert(hgtIsvalid("76in"))
    assert(!hgtIsvalid("77in"))
    assert(hgtIsvalid("65in"))
  }
  test("checking hcl valid") {
    assert(!hclIsvalid(""))
    assert(!hclIsvalid("!123456"))
    assert(hclIsvalid("#123456"))
    assert(!hclIsvalid("#1234567"))
    assert(hclIsvalid("#12abcd"))
    assert(hclIsvalid("#1289ef"))
    assert(!hclIsvalid("#1289eg"))
  }
  test("checking ecl valid") {
    assert(!eclIsvalid(""))
    assert(!eclIsvalid("amc"))
    assert(!eclIsvalid("ambc"))
    assert(eclIsvalid("amb"))
    assert(eclIsvalid("blu"))
    assert(eclIsvalid("brn"))
    assert(eclIsvalid("gry"))
    assert(eclIsvalid("grn"))
    assert(eclIsvalid("hzl"))
    assert(eclIsvalid("oth"))
  }
  test("checking pid valid") {
    assert(!pidIsvalid(""))
    assert(pidIsvalid("012345678"))
    assert(!pidIsvalid("0123456789"))
    assert(!pidIsvalid("1234abc56"))
  }
}
