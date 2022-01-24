package y2019

import org.scalatest.FunSuite
import y2019.day06_1.{calculate, getNumberOfOrbits, procesInput}

import scala.reflect.runtime.universe.reify

class day06_1Test  extends FunSuite {

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
    "K)L"
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
    ("K","L")
  )
  val checkLeaves = Array("F","H","I","L")

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

  test("Determine ...") {
    assert(calculate(testInput) == 42)
  }
}
