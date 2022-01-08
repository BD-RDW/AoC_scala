package y2015

import org.scalatest.FunSuite

class day03_1Test  extends FunSuite {

  test("Check houses that receive presents") {
    assert(day03_1.trackMovement(">") == 2)
    assert(day03_1.trackMovement("^>v<") == 4)
    assert(day03_1.trackMovement("^v^v^v^v^v") == 2)
  }
  test("Determine correct movement") {
    assert(day03_1.determinePosition('^', (0,0)) == (0,1))
    assert(day03_1.determinePosition('v', (0,0)) == (0,-1))
    assert(day03_1.determinePosition('<', (0,0)) == (-1,0))
    assert(day03_1.determinePosition('>', (0,0)) == (1,0))
    assert(day03_1.determinePosition('^', (7,3)) == (7,4))
    assert(day03_1.determinePosition('v', (2,6)) == (2,5))
    assert(day03_1.determinePosition('<', (8,11)) == (7,11))
    assert(day03_1.determinePosition('>', (3,9)) == (4,9))
  }

}
