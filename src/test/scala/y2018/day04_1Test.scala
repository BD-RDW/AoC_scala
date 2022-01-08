package y2018

import org.scalatest.FunSuite
import y2018.day04_1.{processLines, calculate, getGuardMostlySleeping}

class day04_1Test  extends FunSuite {

  val input1: Array[String] = Array(
    "[1518-11-01 00:00] Guard #10 begins shift",
    "[1518-11-01 00:05] falls asleep",
    "[1518-11-01 00:25] wakes up",
    "[1518-11-01 00:30] falls asleep",
    "[1518-11-01 00:55] wakes up",
    "[1518-11-01 23:58] Guard #99 begins shift",
    "[1518-11-02 00:40] falls asleep",
    "[1518-11-02 00:50] wakes up",
    "[1518-11-03 00:05] Guard #10 begins shift",
    "[1518-11-03 00:24] falls asleep",
    "[1518-11-03 00:29] wakes up",
    "[1518-11-04 00:02] Guard #99 begins shift",
    "[1518-11-04 00:36] falls asleep",
    "[1518-11-04 00:46] wakes up",
    "[1518-11-05 00:03] Guard #99 begins shift",
    "[1518-11-05 00:45] falls asleep",
    "[1518-11-05 00:55] wakes up"
  )

  test("Determine ...") {
    assert(calculate(input1) == 240)
  }

  test("Check arranging info") {
    val info = processLines(input1)
    assert(info.length == 6)
    assert(info.zip(Array((10, 5, 25),(10,30, 55),(99,40, 50),(10,24, 29),(99,36, 46),(99,45, 55))).filter(z => z._1 != z._2).length == 0)
  }

  test("Check most sleeping guard") {
    assert(getGuardMostlySleeping((List((10, 20),(10,25),(99,10),(10,5),(99,10),(99,10)))) == 10)
  }
}
