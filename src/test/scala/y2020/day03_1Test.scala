package y2020

import org.scalatest.FunSuite

class day03_1Test  extends FunSuite {

  val input1 = Array(
    "..##.......",
    "#...#...#..",
    ".#....#..#.",
    "..#.#...#.#",
    ".#...##..#.",
    "..#.##.....",
    ".#.#.#....#",
    ".#........#",
    "#.##...#...",
    "#...##....#",
    ".#..#...#.#"
  )
  test("Determine ...") {
    assert(day03_1.calculate(input1) == 7)
  }

}
