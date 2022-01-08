package y2015

object day04_2 {

  // Result ?????
  val input = "bgvyzdsv"

  def main(args: Array[String]): Unit = {
    println(f"The MD5 hash of input ${input}%s results in ${calculate(input)}%d")
  }

  def prefixZerosUpToStringLength(str: String, len: Int): String = {
    var result = str
    while (result.length < len) {
      result = "0" + result
    }
    result
  }

  def md5HashString(s: String): String = {
    import java.math.BigInteger
    import java.security.MessageDigest
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(s.getBytes)
    val bigInt = new BigInteger(1,digest)
    val hashedString = bigInt.toString(16)
    prefixZerosUpToStringLength(hashedString, 32)
  }
  def calculate(str: String): Int = {
    var cnt = -1
    var result:String = null
    do {
      cnt+=1
      result = md5HashString(str+ cnt.toString)
    } while (!result.startsWith("000000"))
    cnt
  }

}
