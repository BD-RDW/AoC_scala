package y2019

import org.scalatest.FunSuite

class day05_1Test  extends FunSuite {
  val testArray = Array(1002,4,3,4,33)

  test("Determine previous program result") {
    assert(day05_1.execute(Array(1,9,10,3,2,3,11,0,99,30,40,50)) == 3500)
  }

  test("Determine program result") {
    assert(day05_1.execute(testArray) == 99)
  }

}
