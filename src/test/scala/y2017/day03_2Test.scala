package y2017

import org.scalatest.FunSuite

import scala.math.pow

class day03_2Test  extends FunSuite {

  test("Check calculate") {
    assert(day03_2.calculate(6) == 10)
    assert(day03_2.calculate(805) == 806)
  }

  test("Check change of direction is needed") {
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((1,0), Direction.east, 0)))
    assert(!day03_2.shouldDirectionChangeBeforeMoving(Movement((1,0), Direction.north, 1)))
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((1,1), Direction.north, 1)))
    assert(!day03_2.shouldDirectionChangeBeforeMoving(Movement((0,1), Direction.west, 1)))
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((-1,1), Direction.west, 1)))
    assert(! day03_2.shouldDirectionChangeBeforeMoving(Movement((-1,0), Direction.south, 1)))
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((-1,-1), Direction.south, 1)))
    assert(!day03_2.shouldDirectionChangeBeforeMoving(Movement((-1,0), Direction.south, 1)))
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((-1,-1), Direction.south, 1)))
    assert(! day03_2.shouldDirectionChangeBeforeMoving(Movement((0,-1), Direction.east, 1)))
    assert(! day03_2.shouldDirectionChangeBeforeMoving(Movement((1,-1), Direction.east, 1)))
    assert(day03_2.shouldDirectionChangeBeforeMoving(Movement((2,-1), Direction.east, 1)))
  }

  test("Check moving along") {
    assert(day03_2.moveToNextCell(Movement((0, 0), Direction.east, 1)) == Movement((1, 0), Direction.east, 1))
    assert(day03_2.moveToNextCell(Movement((1, 0), Direction.north, 1)) == Movement((1, 1), Direction.north, 1))
    assert(day03_2.moveToNextCell(Movement((1, 1), Direction.west, 1)) == Movement((0, 1), Direction.west, 1))
    assert(day03_2.moveToNextCell(Movement((0, 1), Direction.west, 1)) == Movement((-1, 1), Direction.west, 1))
    assert(day03_2.moveToNextCell(Movement((-1, 1), Direction.south, 1)) == Movement((-1, 0), Direction.south, 1))
    var moving = Movement((0, 0), Direction.east, 0)
    for(i <- 1 to 15) {
      print(moving.position + " -> ")
      if (day03_2.shouldDirectionChangeBeforeMoving(moving)) moving = day03_2.changeDirection(moving)
      moving = day03_2.moveToNextCell(moving)
      println(moving.position)
    }
    assert(moving == Movement((-1,2), Direction.west, 2))
  }
}

