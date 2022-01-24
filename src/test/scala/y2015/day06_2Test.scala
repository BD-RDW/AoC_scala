package y2015

import org.scalatest.FunSuite
import y2015.day06_2.{calculate, extractWhat2Do, getSwitchFunction}

class day06_2Test  extends FunSuite {

  val instructions = Array(
    "turn on 1,1 through 2,9",
    "toggle 0,4 through 4,5",
    "turn off 0,5 through 3,6"
  )


  test("Determine ...") {
    assert(calculate(instructions) == 32)
  }

  test("Checking decomposition of the instruction") {
    assert(extractWhat2Do("turn on 0,0 through 999,999") == ("turn on", (0,0), (999,999) ))
    assert(extractWhat2Do("toggle 0,0 through 999,0") == ("toggle", (0,0), (999,0) ))
    assert(extractWhat2Do("turn off 499,499 through 500,500 ") == ("turn off", (499,499), (500,500) ))
  }

  test("Checking Int function selection") {
    assert(getSwitchFunction("turn off")(0) == 0)
    assert(getSwitchFunction("turn off")(3) == 2)
    assert(getSwitchFunction("turn on")(0) == 1)
    assert(getSwitchFunction("turn on")(1) == 2)
    assert(getSwitchFunction("toggle")(0) == 2)
    assert(getSwitchFunction("toggle")(4) == 6)
  }

}
