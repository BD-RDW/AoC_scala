package y2021

import org.scalatest.FunSuite
import y2021.day05_2.{addDiagonalLineToArea, addHorizontalLineToArea, addVerticalLineToArea, calculate}

class day05_2Test  extends FunSuite {

  val test = Array(
    "0,9 -> 5,9",
    "8,0 -> 0,8",
    "9,4 -> 3,4",
    "2,2 -> 2,1",
    "7,0 -> 7,4",
    "6,4 -> 2,0",
    "0,9 -> 2,9",
    "3,4 -> 1,4",
    "0,0 -> 8,8",
    "5,5 -> 8,2"
  )

  test("Determine ...") {
    assert(calculate(test) == 12)
  }

  test("Adding diagonal line to area") {
    val testArea = addDiagonalLineToArea(Array.fill(10,10)(0), 1, 3, 5, 7)
    val checkArea = Array.fill(10,10)(0)
    checkArea(3)(1) = 1
    checkArea(4)(2) = 1
    checkArea(5)(3) = 1
    checkArea(6)(4) = 1
    checkArea(7)(5) = 1
    val t1 = testArea.flatMap(r => r)
    val t2 = checkArea.flatMap(r => r)
    assert(t1.zip(t2).filter(z => z._1 != z._2).length == 0)
  }
  test("Adding another diagonal line to area") {
    val testArea = addDiagonalLineToArea(Array.fill(10,10)(0), 7, 1, 2, 6)
    val checkArea = Array.fill(10,10)(0)
    checkArea(1)(7) = 1
    checkArea(2)(6) = 1
    checkArea(3)(5) = 1
    checkArea(4)(4) = 1
    checkArea(5)(3) = 1
    checkArea(6)(2) = 1
    val t1 = testArea.flatMap(r => r)
    val t2 = checkArea.flatMap(r => r)

    testArea.foreach(x => {
      x.foreach(y => print(y + " "))
      println()
    })
    checkArea.foreach(x => {
      x.foreach(y => print(y + " "))
      println()
    })

    assert(t1.zip(t2).filter(z => z._1 != z._2).length == 0)
  }
  test("Adding vertical line to area") {
    val testArea = addVerticalLineToArea(Array.fill(10,10)(0), 3, 2, 6)
    val checkArea = Array.fill(10,10)(0)
    checkArea(2)(3) = 1
    checkArea(3)(3) = 1
    checkArea(4)(3) = 1
    checkArea(5)(3) = 1
    checkArea(6)(3) = 1
    val t1 = testArea.flatMap(r => r)
    val t2 = checkArea.flatMap(r => r)
    assert(t1.zip(t2).filter(z => z._1 != z._2).length == 0)
  }

  test("Adding horizontal line to area") {
    val testArea = addHorizontalLineToArea(Array.fill(10,10)(0), 3, 2, 6)
    val checkArea = Array.fill(10,10)(0)
    checkArea(3)(2) = 1
    checkArea(3)(3) = 1
    checkArea(3)(4) = 1
    checkArea(3)(5) = 1
    checkArea(3)(6) = 1
    val t1 = testArea.flatMap(r => r)
    val t2 = checkArea.flatMap(r => r)
    assert(t1.zip(t2).filter(z => z._1 != z._2).length == 0)
  }
}
