package y2021

import scala.collection.mutable.ArrayBuffer

object day04_2 {

  // Result 8112
  val input = readInputStrings("y2021/day04_input.txt")

  def main(args: Array[String]): Unit = {
    println(f"These ${input.length}%d lines of the input result in board ${calculate(input)}%d winning")
  }

  def processInput(strArr: Array[String]):(Array[Int],Array[Array[ArrayBuffer[(Int,Boolean)]]]) = {
    var cards: Array[Array[ArrayBuffer[(Int,Boolean)]]] = Array()
    for(i <- 2 until strArr.length by 6 ) {
      val card = Array.fill[ArrayBuffer[(Int,Boolean)]](5)(ArrayBuffer.fill[(Int,Boolean)](5)(-1,false))
      for(j <- i until i + 5) {
        card(j-i) = strArr(j).trim.split("\\s+").map(str => (str.trim.toInt, false)).to(ArrayBuffer)
      }
      cards = cards :+ card
    }
    (strArr(0).split(",").map(s => s.trim.toInt), cards)
  }

  def checkForBingo(card: Array[ArrayBuffer[(Int, Boolean)]], col: Int, row: Int): Boolean = {
    (Array(card(0)(row),card(1)(row),card(2)(row),card(3)(row),card(4)(row)).map(s => s._2).fold(true)((s,a) => s && a)
      || card(col).map(s => s._2).fold(true)((s,a) => s && a))
  }

  def checkNumberOnCard(num: Int, card: Array[ArrayBuffer[(Int, Boolean)]]): Boolean = {
    for(col <- 0 to 4) {
      for(row <- 0 to 4) {
        if (card(col)(row)._1 == num) {
          card(col)(row) = (card(col)(row)._1, true)
          return checkForBingo(card,col,row)
        }
      }
    }
    false
  }

  def calculate(strArr: Array[String]): Int = {
    var(numbersDrawn:Array[Int], cards:Array[Array[ArrayBuffer[(Int,Boolean)]]]) = processInput(strArr)
    var lastCardToWin: Array[ArrayBuffer[(Int,Boolean)]] = null
    var lastNumberDrawn = -1
    for (num <- numbersDrawn) {
      if (lastCardToWin == null) {
        var cardsToRemove: Array[Array[ArrayBuffer[(Int, Boolean)]]] = Array()
        for (card <- cards) {
          if (checkNumberOnCard(num, card)) {
            cardsToRemove = cardsToRemove :+ card
          }
        }
        if (cardsToRemove.length > 0) {
          cards = cards.filter(c => !cardsToRemove.contains(c))
          if (cards.length == 0) {
            lastCardToWin = cardsToRemove(0)
            lastNumberDrawn = num
          }
        }
      }
    }
    lastNumberDrawn * lastCardToWin.flatMap(s => s).filter(s => !s._2).map(s => s._1).sum
  }
  def readInputStrings(filename: String):Array[String] = {
    val source = scala.io.Source.fromResource(filename)
    try source.getLines().toArray finally source.close()
  }
}
