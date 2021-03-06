package y2020

object day03_1 {


  def main(args: Array[String]): Unit = {
    println(f"Wandelend door de input bestaande uit ${input.length}%d regels komen we ${calculate(input)}%d bomen tegen")
  }

  def calculate(strArr: Array[String]): Int = {
    var rightIndex = 0
    var downIndex = 0
    var cntTrees = 0

    do {
      rightIndex = rightIndex % strArr(0).length
      cntTrees += (if (strArr(downIndex).charAt(rightIndex) == '#') 1 else 0)
      rightIndex += 3
      downIndex += 1
    } while (downIndex < strArr.length)
    cntTrees
  }

  // Result 259
  val input = Array(
    "......#...........#...#........",
    ".#.....#...##.......#.....##...",
    "......#.#....#.................",
    "..............#.#.......#......",
    ".....#.#...##...#.#..#..#..#..#",
    ".......##...#..#...........#...",
    ".......#.##.#...#.#.........#..",
    "..#...##............##......#.#",
    ".......#.......##......##.##.#.",
    "...#...#........#....#........#",
    "#............###.#......#.....#",
    "..#........#....#..#..........#",
    "..#..##....#......#..#......#..",
    "........#......#......#..#..#..",
    "..#...#....#..##.......#.#.....",
    ".....#.#......#..#....#.##.#..#",
    "......###.....#..#..........#..",
    ".#................#.#..........",
    ".........#..#...#......##......",
    "##...#....#...#.#...#.##..#....",
    "...##...#....#.........###.....",
    ".#.#....#.........##...........",
    "....#.#..#..#...........#......",
    "..#..#.#....#....#...#.........",
    "..........##.....#.##..........",
    "..#.#....#..##......#.#.....##.",
    "..#...#.##......#..........#...",
    "......#....#..#.....#.....#...#",
    "#.#...##.#.##.........#..#.....",
    "...#.#.#.........#.....#.#.#...",
    "..#.........#...............#..",
    "#..##.....#.........#....#.....",
    "...#....##..##...........##..#.",
    "......##.................#.#...",
    "##.......#....#.#.#.....#......",
    "....#.#...#.................##.",
    "#...#.........##.....#.........",
    "#....#.###..#.....##.#....#....",
    "#..#....#...#....#.#.#.........",
    ".......#...........#....#.....#",
    "#...#.............#........#...",
    ".......#.....#...#..#.........#",
    ".##.....##.....##.......#......",
    "....##...##.......#..#.#.....#.",
    ".##.........#......#........##.",
    ".......#...#...###.#..#........",
    "..#..###......##..##...........",
    ".#..#......##..#.#.........#...",
    "...#.......#........#...#.#....",
    "...#....#..#....#.....##.......",
    "............#......#..........#",
    ".#.......#......#.#....#..#.#..",
    "##.........#.#.#..........#....",
    "....##.....#...................",
    ".......#..#........#...........",
    "....##.#..#......###.......#...",
    "....#....#...#.#......#...#...#",
    ".......#.....##..#....#...#....",
    "#...#........#.........#..##...",
    "...........##.........#.#...#..",
    "....................#....#.##..",
    ".#..#..#.........#....#..#..##.",
    "......................#........",
    "..###....#.......#.....###.##..",
    "......#......#.......#.....#..#",
    ".....#...#.##...#......#....#..",
    ".....#.....##.............#....",
    "....#......##..#....#.......#..",
    ".##....#..##......###....#..#..",
    "...###.#.............##...#.#..",
    ".....#.....#.....#...#..#.#....",
    "..#.#.....###......#.......#...",
    "..........#.##......#.........#",
    "..##..#.......................#",
    "........#......#............#..",
    "#..#..#..#.#......#..#....#....",
    "...##......#.............#....#",
    "...........#..#..##.......#....",
    ".....#.........#.#..#..........",
    "##...#.......#.#....#..#..#....",
    "#.#.#...........#.##.#.#..###..",
    "#..#...........#.........##....",
    "............#.#..............#.",
    ".#....#....##.#...........#..#.",
    "....#...#..#...#....#....#.....",
    "....#....#...#..#......#.......",
    ".#.#.........#.......#.##......",
    ".#..##...#........#...........#",
    "##...#..#...#...#.....#...#....",
    "....###.#..#.......##.#..#...#.",
    "...##.......####...##.#........",
    "#....#....#.#............#..#..",
    "#.#.#...#...................##.",
    "##......#...........#..........",
    "#..#..#....#.#...#......#......",
    ".##...#.....#...#........#.....",
    "..#............#..............#",
    "###........#..#....#...#......#",
    "###..##......#.##...........#..",
    "........#......#..#.....#......",
    "...#..........#..#...........#.",
    "....#..#..#....#........#....#.",
    ".#.................#####..##..#",
    ".....#...##..#..........#.##...",
    "..#..............#...####......",
    ".....#.##..................#.#.",
    "...#.#..#..#........#..........",
    "...........#....#.#..#.........",
    ".....##.......#......#..#.#.#..",
    "...#.............##...#........",
    "...............#.......##.##.##",
    ".....#........#........#.#..#..",
    "...#..#.........#...##...###...",
    "...#.#.............###.#.....#.",
    ".#..........#......###.#.#.....",
    "....##..##.............###.....",
    "..#..#.#...##...#.......##.....",
    "..........###........#.....#.#.",
    "#.#....#..#..#......#...#...#..",
    ".........#......##.......#.#..#",
    "...#.....#.........##..#..#....",
    ".....##.#..##.##..##...........",
    "...#.#.##....#..#..#......#..#.",
    "#....#....#.............#...##.",
    "#......#..#.####.#.##.#....##..",
    "##.#.#....##..................#",
    ".....##......#.......##.......#",
    "..#......#.#..#...##......##...",
    "..#....##....#.........#..##...",
    ".###.....#....##...........#...",
    ".........#......#.#........#...",
    "...#...#..#.#....######.#..#...",
    "###......#.#.#.........##.#....",
    ".....#...#.........#...#.......",
    "....#.............#.#.........#",
    "..##...#...#.......#......#....",
    ".....#...#.#...#...#..#........",
    ".#......#......................",
    "...###..#..#....#...##.#.......",
    ".#.#.....##...#...#.....#...##.",
    ".....###..###....##............",
    ".....##....#..#.....#.##.......",
    "#........#.........#...#..#....",
    "...#.#.........#..#.......#.#..",
    "....#.#....##.....#..........#.",
    ".#..#....#..#.#..#..#.........#",
    "#...#....#..............#......",
    ".........#.....#.##...##...###.",
    ".....#....##............#..#...",
    ".....#.#...........#..#....#...",
    ".#..........#...#......#.....#.",
    ".#...........#.....#..#........",
    "..............#......##...#..#.",
    "...#.........#..#....#..##...##",
    "..##...#..................#....",
    "#.....#.................#......",
    "...#......#..#..........#.#....",
    "......#..#.....#.....##...#..#.",
    "......#........#..........#....",
    "...##.##....#..##.#..........#.",
    "..........#..#.#.##............",
    "..##........................#..",
    ".....#.#.#......#....#....##...",
    "#....#.........#........#......",
    ".##.......#...#...#........##..",
    "....##......#....#.#..........#",
    "..#.......#..............#.....",
    ".....#......#.#...#..#.#.#....#",
    ".....#..#........#.##.##.......",
    "##........#..........#.........",
    ".....#..##....#.#......###..##.",
    "#.#...##.........#.#.....#..#..",
    "#....#.#...#........#.....#..#.",
    "........................#......",
    "....###......#............#...#",
    "...#..##......#..##.........#..",
    ".............#...#......#..#..#",
    "....#......#....#...........#..",
    "..#.#.####.#.....##........#..#",
    "#..#...#..#..#.......#.#..#....",
    "..#..#..#....#.#.........##..#.",
    ".......#......#.#............#.",
    "...#.............#.#.....#.....",
    "...#.#.........##...#.#.......#",
    "........#...#...........##...#.",
    "..........#....#......#....##..",
    "..........#...........#........",
    "...#..#...#..........#......#..",
    "......#......#....#.....#..#.#.",
    "........##.................#..#",
    ".#........#.#...........#......",
    "#...#........#.#.#.....#.#.#...",
    ".........#........#..#..#....#.",
    "##........#..........#....#..#.",
    ".#.##...........#..#.#..##....#",
    ".......#.#....#..#......#......",
    "..#.....#........##..#......###",
    "..#...#..................#....#",
    "......#...#..#.##.......#......",
    "........#...#.#................",
    ".........#............#........",
    "..#.....##....#.#..##..........",
    "#.....#..........#....#........",
    "....#.#...#...##....#.....##...",
    "..#.#.......#.............#...#",
    "...##..............#......#....",
    "#......#...#................##.",
    ".#.#...#.#..#..................",
    "...##.......#...........#.#.#..",
    "#......#.#.#........#.##...####",
    ".......#..#.#.........#.#.##..#",
    "..............#....#.........#.",
    "...........#.#..#....##......#.",
    "#.............#...##..#.......#",
    ".........#............#...#.##.",
    ".......#.........#.#.....#..#..",
    "........................#.#.##.",
    "#......#.#......#.........#....",
    "...#.......#.......#.....#.....",
    "#..#....#................#...#.",
    "........#.#..##......#.........",
    "#..#...##....##....##.........#",
    ".......#...#...###.............",
    "#.#..#........#.#.#............",
    "#.....#........##.........#.#..",
    ".#..........#....#.#....###....",
    ".#.....#...#.#........#..#.##..",
    "...#.##......#..#.............#",
    "..##..#.#...................#..",
    ".....#....#...#.#...#...#......",
    ".....#..#.#....#.#.............",
    "#.#....#.#.##..###..........#..",
    "........#.#.............#..#...",
    ".........#.......#.............",
    ".##.#............##...#........",
    "......#................#.......",
    "...............#..#...........#",
    "...#.......#...#.##.....#....#.",
    "##..##..#..........#...........",
    ".##.#.......#...#..#...#...#...",
    "....#..#...........#....#.##...",
    ".#........#........#....#......",
    ".......#...#.##.#..#.#..#......",
    ".#..#......#....#...##....#.#..",
    "......#...##.#.....##.###.....#",
    ".#....#..#......#...#.#.....#..",
    "#............#....##...##.##...",
    "#...#.#....#...#.......##...##.",
    "#...........#.##..#....#.....#.",
    "...#..#...#.........#.......#..",
    ".#....#.....#............#.#..#",
    ".#.....#.#...#.#....##......###",
    "..#..#.#.#...#..#.............#",
    "...#...#..#....#........#...##.",
    ".......#.....#...##...........#",
    "#.##.................#...##...#",
    "..............##........#.....#",
    "............#...#..#.......#.#.",
    "#.#.....#.........#...#......#.",
    "#.###..#......#..#..#...#.....#",
    ".....#.......#.................",
    "........#..#......#.#...#......",
    "#.......#..#........#...#..#...",
    "..#...#.......##.............#.",
    "#.......#.......##...#.........",
    ".........#....#.#..##.....#...#",
    "..#.....#.#.......#....#.......",
    "...#.......#.....#..##.#..#....",
    "....#.......#.#.#..............",
    ".#..#......#........#.#..##..##",
    "....#...#.##.#...#....##...#...",
    "#..##..#.....#.......#.........",
    "....#..#..#.#............#.....",
    "#.......##...##..##............",
    "...............................",
    "....#.......#.##...#.....#.#...",
    "...#........#....#.#..#..#.....",
    "##.......#.....##.#.#....#....#",
    "#.............#...........#.##.",
    "#...........#.#..........#.....",
    "#..#....#....#.#.........#.#...",
    "......#.#.#..#.#.#.............",
    "...#.....#........##....#......",
    "..#...#...#.#.......#......#...",
    ".##........#...#..#..........#.",
    "..#...........#..##.....##.....",
    "............#..#.#...#.....#...",
    "..........#....##.......#......",
    "....#....#.................#..#",
    "....#...............#.........#",
    "..#.#...#......#..........##...",
    ".....#...........#.........#..#",
    ".......#.....##.....#.#........",
    ".#.#..........#....#...........",
    ".#..##....#........#....#......",
    "....#.#..#.......#..#.........#",
    "..#....#.....#......#..#.......",
    "......#........#.......#...#.#.",
    ".......#.......#....#.....##...",
    "....##........#..#...#.#..#...#",
    ".#......#...........##....#....",
    "##....##......#.......#.......#",
    ".##....#.##......#.......##..#.",
    "...#..#.#.#.......#..#.###.....",
    "..........##....#..#.##........",
    "...#........###.#..#........#..",
    ".....#....#..##....#.....#....#",
    "#..........#..........#.#....#.",
    "..#....#.....#..............#..",
    "#..................#......#.##.",
    ".#...#.#.....#.........##......",
    "...#...........#.....#......#..",
    "......#.....#.#..##......##....",
    "...#....###..#.....#..#..##..##",
    "......#.......##..#..#.........",
    "#..#.#....#.#..#..........##.#.",
    "..#..#..##..#.#.#.#.....#......",
    "..#.#...#..#.....###.#.........",
    "##.#.#......#........#.####....",
    ".............#..#..#....#......",
    "...##..........#.......#.#....#",
    "..#.....................#......",
    "..#..#...##...#.##........#...."
  )
}
