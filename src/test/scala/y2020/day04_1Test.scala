package y2020

import org.scalatest.FunSuite
import y2020.day04_1.{buildPassports, calculate, isValid, passport, processInput}

class day04_1Test  extends FunSuite {

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
  val checkArray = Array(
    passport("1937","2017","2020","183cm","#fffffd","gry","860033327","147"),
    passport("1929","2013","2023",""     ,"#cfa07d","amb","028048884","350"),
    passport("1931","2013","2024","179cm","#ae17e1","brn","760753108",""),
    passport(""    ,"2011","2025","59in" ,"#cfa07d","brn","166559648","")
  )

  test("Determine ...") {
    assert(calculate(input1) == 2)
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
}
