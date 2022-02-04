package y2019

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Determine program result") {
    assert(day02_1.execute(Array(1,9,10,3,2,3,11,0,99,30,40,50)) == 3500)
  }

}
