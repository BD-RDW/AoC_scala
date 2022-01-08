package y2019

import org.scalatest.FunSuite

class day03_2Test  extends FunSuite {

  def input1 = Array("R8,U5,L5,D3", "U7,R6,D4,L4")
  def input2 = Array("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")
  def input3 = Array("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")

  test("Check line points") {
    var points = day03_2.calculateLines(day03_2.processinput(input1))
    assert(points(0).zip(Array(("-",0,0,0), ("H",8,0,8), ("V",8,5,13), ("H",3,5,18), ("V",3,2,21))).filter(z => z._1 != z._2).length == 0)
    assert(points(1).zip(Array(("-",0,0,0), ("V",0,7,7), ("H",6,7,13), ("V",6,3,17), ("H",2,3,21))).filter(z => z._1 != z._2).length == 0)

    points = day03_2.calculateLines(day03_2.processinput(input2))
    assert(points(0).zip(Array(("-",0,0,0), ("H",75,0,75), ("V",75,-30,105),("H",158,-30,188),("V",158,53,271), ("H",146,53,283), ("V",146,4,332), ("H",217,4,403), ("V",217,11,410), ("H",145,11,482))).filter(z => z._1 != z._2).length == 0)
    assert(points(1).zip(Array(("-",0,0,0), ("V",0,62,62), ("H",66,62,128), ("V",66,117,183), ("H",100,117,217), ("V",100,46,288), ("H",155,46,343), ("V",155,-12,401), ("H",238,-12,484))).filter(z => z._1 != z._2).length == 0)
  }

  test("check line intersection") {
    assert(day03_2.getIntersection(((1,2),(3,2)),((2,0),(2,4))) == (2,2))
    assert(day03_2.getIntersection(((1,5),(3,5)),((2,0),(2,4))) == null)
    assert(day03_2.getIntersection(((1,-1),(3,-1)),((2,0),(2,4))) == null)
    assert(day03_2.getIntersection(((1,2),(3,2)),((0,0),(0,4))) == null)
    assert(day03_2.getIntersection(((1,2),(3,2)),((4,0),(4,4))) == null)
  }
  // 4
  // 3   |
  // 2 - + -
  // 1   |
  // 0 1 2 3 4
  // ((1,2),(3,2)) horLine
  // ((2,1),(2,3)) vertLine

  test("check intersections") {
    val points = day03_2.calculateLines(day03_2.processinput(input1))
    val intersections: List[(Int,Int,Int)] = day03_2.determinelineIntersections(points)
    assert(intersections.length == 2)
    assert(intersections.contains((6,5,30)))
    assert(intersections.contains((3,3,40)))
  }

  test("check shortest distance") {
    assert(day03_2.calculate(input1) == 30)
    assert(day03_2.calculate(input2) == 610)
    assert(day03_2.calculate(input3) == 410)
  }

}
