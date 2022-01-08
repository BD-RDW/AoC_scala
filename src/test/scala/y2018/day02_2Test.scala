package y2018

import org.scalatest.FunSuite

class day02_2Test extends FunSuite {

  test("Determine common characters for the two Ids that only differ 1 character") {
    assert(day02_2.findCommonCharacters(Array("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")) == "fgij")
  }

  test("Fijd the 2 Ids that differ only by 1 character") {
    assert(day02_2.findTheTwoIdsThatOnlyDifferOneCharacter(Array("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")).size == 2)
    assert(day02_2.findTheTwoIdsThatOnlyDifferOneCharacter(Array("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")).zip(Array("fghij", "fguij")).filter(x => x._1 != x._2).length == 0)
  }

  test("Determine characters appearing 2 or 3 times") {
//    assert(day02_2.findCharactersThatAppear2or3Times("bababc").keys.toList.sorted.zip(Array('a','b')).filter(x => x._1 != x._2).length == 0)
//    assert(day02_2.findCharactersThatAppear2or3Times("abbcde").keys.toList.sorted.zip(Array('b')).filter(x => x._1 != x._2).length == 0)
//    assert(day02_2.findCharactersThatAppear2or3Times("abcccd").keys.toList.sorted.zip(Array('c')).filter(x => x._1 != x._2).length == 0)
//    assert(day02_2.findCharactersThatAppear2or3Times("aabcdd").keys.toList.sorted.zip(Array('a','d')).filter(x => x._1 != x._2).length == 0)
//    assert(day02_2.findCharactersThatAppear2or3Times("abcdee").keys.toList.sorted.zip(Array('e')).filter(x => x._1 != x._2).length == 0)
//    assert(day02_2.findCharactersThatAppear2or3Times("ababab").keys.toList.sorted.zip(Array('a','b')).filter(x => x._1 != x._2).length == 0)
  }

}
