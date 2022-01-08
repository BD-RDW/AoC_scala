package y2021

import org.scalatest.FunSuite

class day02_2Test extends FunSuite {

  test("Checking position calculation") {
    assert(day02_2.calculatePosition(Array("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")) == (15,60,10))
  }

  test("Check correct processing of an instruction string") {
    assert(day02_2.processInstruction("forward 5", (0,0,0)) == (5,0,0))
    assert(day02_2.processInstruction("down 5", (0,0,0)) == (0,0,5))
    assert(day02_2.processInstruction("up 5", (0,0,0)) == (0,0,-5))
    assert(day02_2.processInstruction("forward 5", (11,11,11)) == (16,66,11))
    assert(day02_2.processInstruction("down 5", (7,3, 5)) == (7,3,10))
    assert(day02_2.processInstruction("up 5", (21,27, 16)) == (21,27,11))
  }

}
