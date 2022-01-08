package y2019

import org.scalatest.FunSuite

class day02_2Test  extends FunSuite {

  test("Determine program result") {
    assert(day02_1.execute(Array(1,9,10,3,2,3,11,0,99,30,40,50)) == 3500)
  }

  test("Determine execution step result") {
    val (ptr1, arr1) = day02_1.processInstructionAt((0, Array(1,9,10,3,2,3,11,0,99,30,40,50)))
    assert(ptr1 == 4)
    assert(arr1.length == 12)
    assert(arr1(3) == 70)
    assert(arr1.zip(Array(1,9,10,70,2,3,11,0,99,30,40,50)).filter(x => x._1 != x._2).length == 0)

    val(ptr2,arr2) = day02_1.processInstructionAt((4, Array(1,9,10,70,2,3,11,0,99,30,40,50)))
    assert(ptr2 == 8)
    assert(arr2(0) == 3500)
    assert(arr2.length == 12)
    assert(arr2.zip(Array(3500,9,10,70,2,3,11,0,99,30,40,50)).filter(x => x._1 != x._2).length == 0)

  }
}
