package y2017

object day03_2 {

  // Result 363010
  val input = 361527

  def main(args: Array[String]): Unit = {
    println(f"The value larger then ${input}%d is ${calculate(input)}%d")
  }

  def moveToNextCell(move: Movement): Movement = {
    move.direction match {
      case Direction.east => Movement((move.position._1 + 1, move.position._2), move.direction, move.lineLimit)
      case Direction.north => Movement((move.position._1, move.position._2 + 1), move.direction, move.lineLimit)
      case Direction.west =>  Movement((move.position._1 - 1, move.position._2), move.direction, move.lineLimit)
      case Direction.south => Movement((move.position._1, move.position._2 - 1), move.direction, move.lineLimit)
    }
  }

  def shouldDirectionChangeBeforeMoving(move: Movement): Boolean = {
    move.direction match {
      case Direction.east => move.position._1 + 1 > move.lineLimit + 1
      case Direction.north => move.position._2 + 1 > move.lineLimit
      case Direction.west =>  (move.position._1 - 1).abs > move.lineLimit
      case Direction.south => (move.position._2 - 1).abs > move.lineLimit
    }
  }

  def changeDirection(move: Movement): Movement = {
    Movement(move.position, Direction.next(move.direction), if(Direction.next(move.direction) == Direction.north) move.lineLimit + 1 else move.lineLimit)
  }

  def getValueAt(position: (Int, Int), grid: Map[(Int, Int), Int]): Int = {
    if (grid.contains(position)) grid.get(position).get else 0
  }

  def determineValue(moving: Movement, grid: Map[(Int, Int), Int]): Map[(Int, Int), Int] = {
    grid + (moving.position -> (
      getValueAt((moving.position._1 - 1, moving.position._2 + 1), grid)
        + getValueAt((moving.position._1 - 1, moving.position._2), grid)
        + getValueAt((moving.position._1 -1, moving.position._2 - 1), grid)
        + getValueAt((moving.position._1, moving.position._2 + 1), grid)
        + getValueAt((moving.position._1, moving.position._2 - 1), grid)
        + getValueAt((moving.position._1 + 1, moving.position._2 + 1), grid)
        + getValueAt((moving.position._1 + 1, moving.position._2), grid)
        + getValueAt((moving.position._1 + 1, moving.position._2 - 1), grid)
    ))
  }

  def calculate(data: Int): Int = {
    var moving: Movement = Movement((0,0), Direction.east, 0)
    var grid: Map[(Int,Int),Int] = Map(moving.position->1)
    do {
      if (shouldDirectionChangeBeforeMoving(moving)) moving = changeDirection(moving)
      moving = moveToNextCell(moving)
      grid =  determineValue(moving, grid)
    } while(grid.get(moving.position).get < data)
    grid.get(moving.position).get
  }
}
object Direction extends Enumeration {
  type Direction = Value
  val east, north, west, south = Value
  val allValues: Array[Direction] = values.toArray

  def next(q: Direction) = {
    allValues((allValues.indexOf(q) + 1) % allValues.length)
  }
}
case class Movement(position:(Int,Int), direction:Direction.Value, lineLimit:Int)
