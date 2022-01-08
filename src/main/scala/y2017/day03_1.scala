package y2017

import scala.math.{pow, sqrt}

object day03_1 {

  // Result 326
  val input = 361527

  def main(args: Array[String]): Unit = {
    println(f"input ${input}%d results in ${calculate(input)}%d")
  }

  def determineKeypositions(max: Int, eighth: Int):(Int,Int,Int,Int) = {
    (max - 7 * eighth, max - 5 * eighth, max - 3 * eighth, max - eighth)
  }

  def determineSteps(number: Int): Int = {
    if (number == 1) 0
    else {
      val line = determineLine(number);
      val (min, max) = determineLineRange(line)
      val temp = max - min + 1
      val eighth: Int = temp / 8
      val keyPositions = determineKeypositions(max, eighth)
      val tempExtras = ((keyPositions._1 - number).abs, (keyPositions._2 - number).abs, (keyPositions._3 - number).abs, (keyPositions._4 - number).abs)
      val extraSteps = tempExtras._1.min(tempExtras._2).min(tempExtras._3).min(tempExtras._4)
      line + extraSteps

    }
  }

  def calculate(data: Int): Int = {
    determineSteps(data)
  }

  def determineLine(number: Int) : Int = {
    // pow(((i*2)+1) ,2)
    val tempVal = ((sqrt(number)-1)/2).toInt
    if (pow((tempVal*2)+1,2).toInt == number) tempVal else tempVal  + 1
  }
  def determineLineRange(line: Int) : (Int,Int) = {
    (pow((((line-1)*2)+1) ,2).toInt + 1, pow(((line*2)+1) ,2).toInt)
  }

  // 1, 9, 25, 45
}
