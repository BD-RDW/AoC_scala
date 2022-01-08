package y2016

import org.scalatest.FunSuite

class day03_2Test extends FunSuite {

  test("Check valid triangle count") {
    assert(day03_2.countValidTriangles(Array(Array(5,5,25),Array(25,5,5),Array(25,15,11))) ==1 )
  }
  test("Check triangle validity") {
    assert(! day03_2.isValidTriangle(Array(5,10,25)))
    assert(! day03_2.isValidTriangle(Array(25,10,5)))
    assert(day03_2.isValidTriangle(Array(25,15,11)))
  }

}
