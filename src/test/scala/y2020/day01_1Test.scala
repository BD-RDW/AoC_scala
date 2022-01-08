package y2020

import org.scalatest.FunSuite

class day01_1Test  extends FunSuite {

  test("Determine fuel requirement for mass") {
    val result = day01_1.findTwoEntriesThatSumUpTo2020(Array(1721, 979, 366, 299, 675, 1456))
    assert( result._1 * result._2 == 514579)
  }

}
