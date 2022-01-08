package y2021

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Checking position calculation") {
    assert(day02_1.calculatePosition(Array("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")) == (15,10))
  }

  test("Check correct processing of an instruction string") {
    assert(day02_1.processInstruction("forward 5", (0,0)) == (5,0))
    assert(day02_1.processInstruction("down 5", (0,0)) == (0,5))
    assert(day02_1.processInstruction("up 5", (0,0)) == (0,-5))
    assert(day02_1.processInstruction("forward 5", (11,11)) == (16,11))
    assert(day02_1.processInstruction("down 5", (7,3)) == (7,8))
    assert(day02_1.processInstruction("up 5", (21,27)) == (21,22))
  }

}
