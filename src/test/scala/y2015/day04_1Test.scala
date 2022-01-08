package y2015

import org.scalatest.FunSuite
import y2015.day04_1.{calculate, md5HashString}

class day04_1Test  extends FunSuite {

  test("Determine ...") {
    assert(calculate("abcdef") == 609043)
    assert(calculate("pqrstuv") == 1048970)
  }

  test("Checking md5 hash") {
    assert(md5HashString("abcdef609043").startsWith("00000"))
    assert(md5HashString("pqrstuv1048970").startsWith("00000"))
  }
}
