package y2016

import org.scalatest.FunSuite

class day01_1Test extends FunSuite {

  test("process instructions test") {
    var pos = day01_1.processDirections("R2, L3")
    assert(pos._1.abs + pos._2.abs == 5)
    pos = day01_1.processDirections("R2, R2, R2")
    assert(pos._1.abs + pos._2.abs == 2)
    pos = day01_1.processDirections("R5, L5, R5, R3")
    assert(pos._1.abs + pos._2.abs == 12)
  }

  test("Walking test") {
    assert(day01_1.walk(5,day01_1.Direction.north,0,0).equals((0,5)))
    assert(day01_1.walk(5,day01_1.Direction.east,0,0).equals((5,0)))
    assert(day01_1.walk(5,day01_1.Direction.south,0,0).equals((0,-5)))
    assert(day01_1.walk(5,day01_1.Direction.west,0,0).equals((-5,0)))
    assert(day01_1.walk(5,day01_1.Direction.north,7,-2).equals((7,3)))
    assert(day01_1.walk(5,day01_1.Direction.east,-10,12).equals((-5,12)))
    assert(day01_1.walk(5,day01_1.Direction.south,-3,-3).equals((-3,-8)))
    assert(day01_1.walk(5,day01_1.Direction.west,17,7).equals((12,7)))
  }


  test("checkTurnLeft") {
    assert(day01_1.Direction.turnLeft(day01_1.Direction.north) == day01_1.Direction.west)
    assert(day01_1.Direction.turnLeft(day01_1.Direction.east) == day01_1.Direction.north)
    assert(day01_1.Direction.turnLeft(day01_1.Direction.south) == day01_1.Direction.east)
    assert(day01_1.Direction.turnLeft(day01_1.Direction.west) == day01_1.Direction.south)
  }

  test("checkTurnRight") {
    assert(day01_1.Direction.turnRight(day01_1.Direction.north) == day01_1.Direction.east)
    assert(day01_1.Direction.turnRight(day01_1.Direction.east) == day01_1.Direction.south)
    assert(day01_1.Direction.turnRight(day01_1.Direction.south) == day01_1.Direction.west)
    assert(day01_1.Direction.turnRight(day01_1.Direction.west) == day01_1.Direction.north)
  }

  test("TestCompareTuples") {
    val p = (3,1)
    assert(p.equals((3,1)))
  }
}
