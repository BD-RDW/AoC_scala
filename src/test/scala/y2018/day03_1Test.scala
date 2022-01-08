package y2018

import org.scalatest.FunSuite

class day03_1Test  extends FunSuite {

  val input1 = Array("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")
  val grid1 = Array[Array[Int]](
    Array(0,0,0,0,0,0,0),
    Array(0,0,0,1,1,1,1),
    Array(0,0,0,1,1,1,1),
    Array(0,1,1,2,2,1,1),
    Array(0,1,1,2,2,1,1),
    Array(0,1,1,1,1,1,1),
    Array(0,1,1,1,1,1,1)
  )

  test("Determine multiple claims") {
    assert(day03_1.calculate(input1) == 4)
  }
  test("Determine grid dimensions") {
    assert(day03_1.processClaimLine(input1).length == 3)
    assert(day03_1.determineFabricDimension(day03_1.processClaimLine(input1)) == (7, 7))
  }

  test("Determine plotting claims on fabric") {
    val claims = day03_1.processClaimLine(input1)
    assert(day03_1.determineFabricDimension(claims) == (7, 7))
    val grid = day03_1.processClaims(claims, Array.ofDim[Int](7,7))
    for(i <- 0 to grid.length - 1)
      assert(grid(i).zip(grid1(i)).filter(z => z._1 != z._2).length == 0)
  }

  test("Checking overlapping squares") {
    var multipleClaim = day03_1.determineDimensions(3, 3, grid1)
    assert(multipleClaim == Day03_Claim("",3,3,2,2))
  }
  test("Checking square counting") {
    assert(day03_1.calculate(input1) == 4)
  }

  test("Checking position inside claim square") {
    assert(!day03_1.pieceOfFabricAllreadyRegistered(3,3, List()))
    assert(day03_1.pieceOfFabricAllreadyRegistered(3,3, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(day03_1.pieceOfFabricAllreadyRegistered(3,4, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(day03_1.pieceOfFabricAllreadyRegistered(4,3, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(day03_1.pieceOfFabricAllreadyRegistered(4,4, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(!day03_1.pieceOfFabricAllreadyRegistered(2,3, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(!day03_1.pieceOfFabricAllreadyRegistered(5,3, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(!day03_1.pieceOfFabricAllreadyRegistered(3,5, List(Day03_Claim("", 3, 3, 2, 2))))
    assert(!day03_1.pieceOfFabricAllreadyRegistered(3,2, List(Day03_Claim("", 3, 3, 2, 2))))
  }

}
