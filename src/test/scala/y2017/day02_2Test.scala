package y2017

import org.scalatest.FunSuite

class day02_2Test extends FunSuite {

  test("Determine checksum for sheet") {
    assert(day02_2.calculateResult(Array(Array(5,9,2,8),Array(9,4,7,3),Array(3,8,6,5))) == 9)
  }

  test("Determine EvenlyDividableValue for row") {
    assert(day02_2.getEvenlyDividableValuesForRow(Array(5,9,2,8)) == 4)
    assert(day02_2.getEvenlyDividableValuesForRow(Array(9,4,7,3)) == 3)
    assert(day02_2.getEvenlyDividableValuesForRow(Array(3,8,6,5)) == 2)
  }

}
