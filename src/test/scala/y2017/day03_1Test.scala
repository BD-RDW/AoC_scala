package y2017

import org.scalatest.FunSuite

import scala.math.{pow, sqrt}

class day03_1Test  extends FunSuite {

  test("Check calculate") {
    //    assert(day03_1.calculate(1) == 0)
    assert(day03_1.calculate(12) == 3)
    assert(day03_1.calculate(23) == 2)
    assert(day03_1.calculate(1024) == 31)
  }

  test("Draw grid") {
    var start = 1
    for(i <- 1 to 21 by 2) {
      println(f"Line ${i}%d bevat the cijfers $start%d to ${pow(i,2).toInt}%d -> diff: ${pow(i,2).toInt - start + 1}%d")
      start = pow(i,2).toInt + 1
    }
    start = 1
    for(i <- 0 to 11) {
      println(f"Line ${i}%d bevat the cijfers $start%d to ${pow(((i*2)+1) ,2).toInt}%d -> diff: ${pow((i*2)+1,2).toInt - start + 1}%d")
      start = pow((i*2)+1,2).toInt + 1
    }
  }

  test("Testing number of steps") {
    assert(day03_1.determineSteps(1) == 0)
    assert(day03_1.determineSteps(2) == 1)
    assert(day03_1.determineSteps(3) == 2)
    assert(day03_1.determineSteps(4) == 1)
    assert(day03_1.determineSteps(5) == 2)
    assert(day03_1.determineSteps(6) == 1)
    assert(day03_1.determineSteps(7) == 2)
    assert(day03_1.determineSteps(8) == 1)
    assert(day03_1.determineSteps(9) == 2)
    assert(day03_1.determineSteps(10) == 3)
    assert(day03_1.determineSteps(11) == 2)
    assert(day03_1.determineSteps(12) == 3)
    assert(day03_1.determineSteps(13) == 4)
    assert(day03_1.determineSteps(14) == 3)
    assert(day03_1.determineSteps(15) == 2)
    assert(day03_1.determineSteps(16) == 3)
    assert(day03_1.determineSteps(17) == 4)
    assert(day03_1.determineSteps(18) == 3)
    assert(day03_1.determineSteps(19) == 2)
    assert(day03_1.determineSteps(20) == 3)
    assert(day03_1.determineSteps(21) == 4)
    assert(day03_1.determineSteps(22) == 3)
    assert(day03_1.determineSteps(23) == 2)
    assert(day03_1.determineSteps(24) == 3)
    assert(day03_1.determineSteps(25) == 4)
    assert(day03_1.determineSteps(26) == 5)
    assert(day03_1.determineSteps(1024) == 31)
  }

  test("Testing range of the line") {
    assert(day03_1.determineLineRange(1) == (2,9))
    assert(day03_1.determineLineRange(2) == (10,25))
    assert(day03_1.determineLineRange(3) == (26,49))
    assert(day03_1.determineLineRange(4) == (50,81))
    assert(day03_1.determineLineRange(5) == (82,121))
  }

  test("Testing determineLine") {
    assert(day03_1.determineLine(2) == 1)
    assert(day03_1.determineLine(3) == 1)
    assert(day03_1.determineLine(4) == 1)
    assert(day03_1.determineLine(5) == 1)
    assert(day03_1.determineLine(6) == 1)
    assert(day03_1.determineLine(7) == 1)
    assert(day03_1.determineLine(8) == 1)
    assert(day03_1.determineLine(9) == 1)
    assert(day03_1.determineLine(10) == 2)
    assert(day03_1.determineLine(11) == 2)
    assert(day03_1.determineLine(24) == 2)
    assert(day03_1.determineLine(25) == 2)
    assert(day03_1.determineLine(26) == 3)
    assert(day03_1.determineLine(27) == 3)
    assert(day03_1.determineLine(48) == 3)
    assert(day03_1.determineLine(49) == 3)
    assert(day03_1.determineLine(50) == 4)
    assert(day03_1.determineLine(51) == 4)
    assert(day03_1.determineLine(80) == 4)
    assert(day03_1.determineLine(81) == 4)
  }
}

// 101	100	 99	 98	 97	 96	 95	 94	 93	 92	 91
// 102	 65	 64	 63	 62	 61	 60	 58	 58	 57	 90
// 103	 66	 37	 36	 35	 34	 33	 32	 31	 56	 89
// 104	 67	 38	 17	 16	 15	 14	 13	 30	 55	 88
// 105	 68	 39	 18	  5	  4	  3	 12	 29	 54	 87
// 106	 69	 40	 19	  6	  1	  2	 11	 28	 53	 86
// 107	 70	 41	 20	  7	  8	  9	 10	 27	 52	 85
// 108	 71	 42	 21	 22	 23	 24	 25	 26	 51	 84
// 109	 72	 43	 44	 45	 46	 47	 48	 49	 50	 83
// 110	 73	 74	 75	 76	 77	 78	 79	 80	 81	 82
// 111	112	113	114	115	116	117	118	119	120	121

