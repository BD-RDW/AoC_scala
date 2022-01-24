package y2015

import org.scalatest.FunSuite
import y2015.day06_1.{calculate, extractWhat2Do, getSwitchFunction}

class day06_1Test  extends FunSuite {

  val instructions = Array(
    "turn on 1,1 through 2,9",
    "toggle 0,4 through 4,5",
    "turn off 0,5 through 3,6"
  )


  test("Determine ...") {
    assert(calculate(instructions) == 16)
  }

  test("Checking decomposition of the instruction") {
    assert(extractWhat2Do("turn on 0,0 through 999,999") == ("turn on", (0,0), (999,999) ))
    assert(extractWhat2Do("toggle 0,0 through 999,0") == ("toggle", (0,0), (999,0) ))
    assert(extractWhat2Do("turn off 499,499 through 500,500 ") == ("turn off", (499,499), (500,500) ))
  }

  test("Checking boolean function selection") {
    assert(!getSwitchFunction("turn off")(true))
    assert(!getSwitchFunction("turn off")(false))
    assert(getSwitchFunction("turn on")(true))
    assert(getSwitchFunction("turn on")(false))
    assert(!getSwitchFunction("toggle")(true))
    assert(getSwitchFunction("toggle")(false))
  }

}
