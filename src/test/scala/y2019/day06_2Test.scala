package y2019

import org.scalatest.FunSuite
import y2019.day06_2.{calculate, getNumberOfOrbits, getPathFor, procesInput}

class day06_2Test  extends FunSuite {

  val testInput = Array(
    "COM)B",
    "B)C",
    "C)D",
    "D)E",
    "E)F",
    "B)G",
    "G)H",
    "D)I",
    "E)J",
    "J)K",
    "K)L",
    "K)YOU",
    "I)SAN"
  )
  val checkInput = Array(
    ("COM","B"),
    ("B","C"),
    ("C","D"),
    ("D","E"),
    ("E","F"),
    ("B","G"),
    ("G","H"),
    ("D","I"),
    ("E","J"),
    ("J","K"),
    ("K","L"),
    ("K","YOU"),
    ("I","SAN")
  )
  test("Checking proces input") {
    val input = procesInput(testInput)
    assert(input.zip(checkInput).filter(z => z._1 != z._2).length == 0)
  }

  test("Checking determing number of orbits") {
    assert(getNumberOfOrbits(procesInput(testInput), "B") == 1)
    assert(getNumberOfOrbits(procesInput(testInput), "C") == 2)
    assert(getNumberOfOrbits(procesInput(testInput), "D") == 3)
    assert(getNumberOfOrbits(procesInput(testInput), "L") == 7)
  }

  test("Checking path") {
    assert(getPathFor(procesInput(testInput), "B").zip(Array("COM","B")).filter(z => z._1 != z._2).length == 0)
    assert(getPathFor(procesInput(testInput), "F").zip(Array("COM","B","C","D","E","F")).filter(z => z._1 != z._2).length == 0)
    assert(getPathFor(procesInput(testInput), "L").zip(Array("COM","B","C","D","E","J","K","L")).filter(z => z._1 != z._2).length == 0)
  }

  test("Determine ...") {
    assert(calculate(testInput) == 4)
  }
}
