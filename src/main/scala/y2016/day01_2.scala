package y2016

object day01_2 {

  // Result 126
  val input = "L1, L5, R1, R3, L4, L5, R5, R1, L2, L2, L3, R4, L2, R3, R1, L2, R5, R3, L4, R4, L3, R3, R3, L2, R1, L3, R2, L1, R4, L2, R4, L4, R5, L3, R1, R1, L1, L3, L2, R1, R3, R2, L1, R4, L4, R2, L189, L4, R5, R3, L1, R47, R4, R1, R3, L3, L3, L2, R70, L1, R4, R185, R5, L4, L5, R4, L1, L4, R5, L3, R2, R3, L5, L3, R5, L1, R5, L4, R1, R2, L2, L5, L2, R4, L3, R5, R1, L5, L4, L3, R4, L3, L4, L1, L5, L5, R5, L5, L2, L1, L2, L4, L1, L2, R3, R1, R1, L2, L5, R2, L3, L5, L4, L2, L1, L2, R3, L1, L4, R3, R3, L2, R5, L1, L3, L3, L3, L5, R5, R1, R2, L3, L2, R4, R1, R1, R3, R4, R3, L3, R3, L5, R2, L2, R4, R5, L4, L3, L1, L5, L1, R1, R2, L1, R3, R4, R5, R2, R3, L2, L1, L5"

  def processInstructions(str: String): (Int, Int) = {
    var positionVisitedTwice:(Int, Int) = null
    var direction = Direction.north
    var posX: Int = 0
    var posY: Int = 0
    var allPositions:List[(Int,Int)] = List()
    str.split(",").foreach(inst => {
      if (inst.trim().charAt(0) == 'R') {
        direction = Direction.turnRight(direction)
      } else {
        direction = Direction.turnLeft(direction)
      }
      val steps = inst.trim().substring(1).toInt
      for ( s <- 1 to steps) {
        val pos:(Int,Int) = walk(1, direction, posX, posY)
        if (allPositions.find(pos.equals(_)) != None && positionVisitedTwice == null) {
          positionVisitedTwice = pos
        }
        allPositions = pos +: allPositions
        posX = pos._1
        posY = pos._2
      }
    })
    positionVisitedTwice
  }

  def walk(steps: Int, direction: Direction.Value, posX: Int, posY: Int): (Int, Int) = {
    var newPosX = posX
    var newPosY = posY
    direction match {
      case Direction.north => newPosY += steps
      case Direction.east => newPosX += steps
      case Direction.south => newPosY -= steps
      case Direction.west => newPosX -= steps
    }
    (newPosX, newPosY)
  }

  def main(args: Array[String]): Unit = {
    var (posX, posY) = processInstructions(input)
    println(f"Instruction ${input.substring(0, 20)}%s visits position ${posX}%d,${posY}%d twice; resulting in a distance of ${posX.abs + posY.abs}%d")
  }

  object Direction extends Enumeration {
    type Direction = Value
    val north, east, south, west = Value
    val allValues: Array[Direction] = values.toArray
    def turnRight(q: Direction) = {
      allValues((allValues.indexOf(q) + 1) % allValues.length)
    }
    def turnLeft(q: Direction) = {
      allValues((allValues.indexOf(q) - 1 + allValues.length) % allValues.length)
    }
  }
}
