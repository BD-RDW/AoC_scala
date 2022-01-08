package y2020

import org.scalatest.FunSuite
import y2020.day03_2.{calculate}

class day03_2Test  extends FunSuite {

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
    val result = calculate(input1,1,1) * calculate(input1,3,1) * calculate(input1,5,1) * calculate(input1,7,1) * calculate(input1,1,2)
    assert(result == 336)
  }

}
