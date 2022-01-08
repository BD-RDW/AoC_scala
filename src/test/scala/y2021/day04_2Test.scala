package y2021

import org.scalatest.FunSuite
import y2021.day04_2.{calculate, checkForBingo, checkNumberOnCard, processInput}

import scala.collection.mutable.ArrayBuffer

class day04_2Test  extends FunSuite {

  val input1 = Array(
    "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
    "",
    "22 13 17 11  0",
    " 8  2 23  4 24",
    "21  9 14 16  7",
    " 6 10  3 18  5",
    " 1 12 20 15 19",
    "",
    " 3 15  0  2 22",
    " 9 18 13 17  5",
    "19  8  7 25 23",
    "20 11 10 24  4",
    "14 21 16 12  6",
    "",
    "14 21 17 24  4",
    "10 16 15  9 19",
    "18  8 23 26 20",
    "22 11 13  6  5",
    " 2  0 12  3  7"
  )

  val card1: Array[ArrayBuffer[(Int, Boolean)]] = Array(
    ArrayBuffer((22, false), (13, false), (17, false), (11, false), (0, false)),
    ArrayBuffer((8, false), (2, false), (23, false), (4, false), (24, false)),
    ArrayBuffer((21, false), (9, false), (14, false), (16, false), (7, false)),
    ArrayBuffer((6, false), (10, false), (3, false), (18, false), (5, false)),
    ArrayBuffer((1, false), (12, false), (20, false), (15, false), (19, false)))
  val card2: Array[ArrayBuffer[(Int, Boolean)]] = Array(
    ArrayBuffer((3, false), (15, false), (0, false), (2, false), (22, false)),
    ArrayBuffer((9, false), (18, false), (13, false), (17, false), (5, false)),
    ArrayBuffer((19, false), (8, false), (7, false), (25, false), (23, false)),
    ArrayBuffer((20, false), (11, false), (10, false), (24, false), (4, false)),
    ArrayBuffer((14, false), (21, false), (16, false), (12, false), (6, false)))
  val card3: Array[ArrayBuffer[(Int, Boolean)]] = Array(
    ArrayBuffer((14, false), (21, false), (17, false), (24, false), (4, false)),
    ArrayBuffer((10, false), (16, false), (15, false), (9, false), (19, false)),
    ArrayBuffer((18, false), (8, false), (23, false), (26, false), (20, false)),
    ArrayBuffer((22, false), (11, false), (13, false), (6, false), (5, false)),
    ArrayBuffer((2, false), (0, false), (12, false), (3, false), (7, false)))

  test("Determine ...") {
    assert(calculate(input1) == 1924)
  }

  test("Checking processing input data") {
    val (numbers, cards) = processInput(input1)
    assert(numbers.length == 27)
    assert(numbers.zip(Array(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)).filter(z => z._1 != z._2).length == 0)
    assert(cards.length == 3)
    assert(cards(0)(0).zip(card1(0)).filter(z => z._1 != z._2).length == 0)
    assert(cards(0)(1).zip(card1(1)).filter(z => z._1 != z._2).length == 0)
    assert(cards(0)(2).zip(card1(2)).filter(z => z._1 != z._2).length == 0)
    assert(cards(0)(3).zip(card1(3)).filter(z => z._1 != z._2).length == 0)
    assert(cards(0)(4).zip(card1(4)).filter(z => z._1 != z._2).length == 0)

    assert(cards(1)(0).zip(card2(0)).filter(z => z._1 != z._2).length == 0)
    assert(cards(1)(1).zip(card2(1)).filter(z => z._1 != z._2).length == 0)
    assert(cards(1)(2).zip(card2(2)).filter(z => z._1 != z._2).length == 0)
    assert(cards(1)(3).zip(card2(3)).filter(z => z._1 != z._2).length == 0)
    assert(cards(1)(4).zip(card2(4)).filter(z => z._1 != z._2).length == 0)

    assert(cards(2)(0).zip(card3(0)).filter(z => z._1 != z._2).length == 0)
    assert(cards(2)(1).zip(card3(1)).filter(z => z._1 != z._2).length == 0)
    assert(cards(2)(2).zip(card3(2)).filter(z => z._1 != z._2).length == 0)
    assert(cards(2)(3).zip(card3(3)).filter(z => z._1 != z._2).length == 0)
    assert(cards(2)(4).zip(card3(4)).filter(z => z._1 != z._2).length == 0)
  }

  test("Check if a card has bingo") {
    val tempCard1 = Array(card1(0).clone(),card1(1).clone(),card1(2).clone(),card1(3).clone(),card1(4).clone())
    tempCard1(0)(0) = (tempCard1(0)(0)._1, true)
    tempCard1(0)(1) = (tempCard1(0)(1)._1, true)
    tempCard1(0)(3) = (tempCard1(0)(3)._1, true)
    tempCard1(0)(4) = (tempCard1(0)(4)._1, true)
    assert(!checkForBingo(tempCard1, 0, 3))
    tempCard1(0)(2) = (tempCard1(0)(2)._1, true)
    assert(checkForBingo(tempCard1, 0, 2))
    val tempCard2 = Array(card1(0).clone(),card1(1).clone(),card1(2).clone(),card1(3).clone(),card1(4).clone())
    tempCard2(0)(3) = (tempCard2(0)(3)._1, true)
    tempCard2(2)(3) = (tempCard2(2)(3)._1, true)
    tempCard2(3)(3) = (tempCard2(3)(3)._1, true)
    tempCard2(4)(3) = (tempCard2(4)(3)._1, true)
    assert(!checkForBingo(tempCard2, 2, 3))
    tempCard2(1)(3) = (tempCard2(1)(3)._1, true)
    assert(checkForBingo(tempCard2, 1, 3))
  }

  test("Check add number to a card and checking for has bingo") {
    val tempCard1 = card1.clone()
    assert(!checkNumberOnCard(22, tempCard1))
    assert(!checkNumberOnCard(21, tempCard1))
    assert(!checkNumberOnCard(1, tempCard1))
    assert(!checkNumberOnCard(6, tempCard1))
    assert(checkNumberOnCard(8, tempCard1))
    // 19  8  7 25 23
    val tempCard2 = card2.clone()
    assert(!checkNumberOnCard(25, tempCard2))
    assert(!checkNumberOnCard(8, tempCard2))
    assert(!checkNumberOnCard(7, tempCard2))
    assert(!checkNumberOnCard(19, tempCard2))
    assert(checkNumberOnCard(23, tempCard2))
  }
}
