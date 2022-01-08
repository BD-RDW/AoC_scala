package y2015

import org.scalatest.FunSuite

class day03_2Test extends FunSuite {

  test("Check houses that receive presents") {
    assert(day03_2.trackMovement("^v") == 3)
    assert(day03_2.trackMovement("^>v<") == 3)
    assert(day03_2.trackMovement("^v^v^v^v^v") == 11)
  }
  test("Determine correct movement") {
    assert(day03_2.determinePosition('^', (0,0)) == (0,1))
    assert(day03_2.determinePosition('v', (0,0)) == (0,-1))
    assert(day03_2.determinePosition('<', (0,0)) == (-1,0))
    assert(day03_2.determinePosition('>', (0,0)) == (1,0))
    assert(day03_2.determinePosition('^', (7,3)) == (7,4))
    assert(day03_2.determinePosition('v', (2,6)) == (2,5))
    assert(day03_2.determinePosition('<', (8,11)) == (7,11))
    assert(day03_2.determinePosition('>', (3,9)) == (4,9))
  }

}
