package y2016

import org.scalatest.FunSuite

class day01_2Test extends FunSuite {

  test("process instructions test") {
    var pos = day01_2.processInstructions("R8, R4, R4, R8")
    assert(pos._1.abs + pos._2.abs == 4)
  }

  test("Walking test") {
    assert(day01_2.walk(5,day01_2.Direction.north,0,0).equals((0,5)))
    assert(day01_2.walk(5,day01_2.Direction.east,0,0).equals((5,0)))
    assert(day01_2.walk(5,day01_2.Direction.south,0,0).equals((0,-5)))
    assert(day01_2.walk(5,day01_2.Direction.west,0,0).equals((-5,0)))
    assert(day01_2.walk(5,day01_2.Direction.north,7,-2).equals((7,3)))
    assert(day01_2.walk(5,day01_2.Direction.east,-10,12).equals((-5,12)))
    assert(day01_2.walk(5,day01_2.Direction.south,-3,-3).equals((-3,-8)))
    assert(day01_2.walk(5,day01_2.Direction.west,17,7).equals((12,7)))
  }


  test("checkTurnLeft") {
    assert(day01_2.Direction.turnLeft(day01_2.Direction.north) == day01_2.Direction.west)
    assert(day01_2.Direction.turnLeft(day01_2.Direction.east) == day01_2.Direction.north)
    assert(day01_2.Direction.turnLeft(day01_2.Direction.south) == day01_2.Direction.east)
    assert(day01_2.Direction.turnLeft(day01_2.Direction.west) == day01_2.Direction.south)
  }

  test("checkTurnRight") {
    assert(day01_2.Direction.turnRight(day01_2.Direction.north) == day01_2.Direction.east)
    assert(day01_2.Direction.turnRight(day01_2.Direction.east) == day01_2.Direction.south)
    assert(day01_2.Direction.turnRight(day01_2.Direction.south) == day01_2.Direction.west)
    assert(day01_2.Direction.turnRight(day01_2.Direction.west) == day01_2.Direction.north)
  }

  test("TestCompareTuples") {
    val p = (3,1)
    assert(p.equals((3,1)))
  }
}
