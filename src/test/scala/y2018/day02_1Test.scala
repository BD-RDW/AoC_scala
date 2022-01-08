package y2018

import org.scalatest.FunSuite

class day02_1Test  extends FunSuite {

  test("Determine checksum for characters appearing 2 or 3 times") {
    assert(day02_1.calculatedCheckSum(Array("abcdef", "bababc", "abbcde", "abcccd","aabcdd","abcdee","ababab")) == 12)
  }

  test("Determine amount of character appearing 2 or 3 times") {
    assert(day02_1.findCharactersThatAppear2or3Times("abcdef").size == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("bababc").size == 2)
    assert(day02_1.findCharactersThatAppear2or3Times("abbcde").size == 1)
    assert(day02_1.findCharactersThatAppear2or3Times("abcccd").size == 1)
    assert(day02_1.findCharactersThatAppear2or3Times("aabcdd").size == 2)
    assert(day02_1.findCharactersThatAppear2or3Times("abcdee").size == 1)
    assert(day02_1.findCharactersThatAppear2or3Times("ababab").size == 2)
  }

  test("Determine characters appearing 2 or 3 times") {
    assert(day02_1.findCharactersThatAppear2or3Times("bababc").keys.toList.sorted.zip(Array('a','b')).filter(x => x._1 != x._2).length == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("abbcde").keys.toList.sorted.zip(Array('b')).filter(x => x._1 != x._2).length == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("abcccd").keys.toList.sorted.zip(Array('c')).filter(x => x._1 != x._2).length == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("aabcdd").keys.toList.sorted.zip(Array('a','d')).filter(x => x._1 != x._2).length == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("abcdee").keys.toList.sorted.zip(Array('e')).filter(x => x._1 != x._2).length == 0)
    assert(day02_1.findCharactersThatAppear2or3Times("ababab").keys.toList.sorted.zip(Array('a','b')).filter(x => x._1 != x._2).length == 0)
  }

}
