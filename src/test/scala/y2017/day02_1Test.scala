package y2017

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Determine checksum for sheet") {
    assert(day02_1.calculateChecksum(Array(Array(5, 1, 9, 5),Array(7,5,3),Array(2,4,6,8))) == 18)
  }

  test("Determine checksum for row") {
    assert(day02_1.getChecksumForRow(Array(5,1,9,5)) == 8)
    assert(day02_1.getChecksumForRow(Array(7,5,3)) == 4)
    assert(day02_1.getChecksumForRow(Array(2,4,6,8)) == 6)
  }

}
