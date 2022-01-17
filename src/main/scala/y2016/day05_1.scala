package y2016

object day05_1 {

  // Result 4543c154
  val input = "ojvtpuvg"

  def main(args: Array[String]): Unit = {
    println(f"For the doorId ${input}%s the password is ${determinePassword(input)}%s")
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

  def getHashThatStartsWithFiveZeros(str: String, i: Int): (String, Int) = {
    var hash = ""
    var index = i
    do {
      hash = md5HashString(str + index)
      index += 1
    }
    while (! hash.startsWith("00000"))
    (hash, index-1)
  }

  def determinePassword(str: String): String = {
    var password = ""
    var index = 0
    for(i <- 0 to 7 ) {
      val(hash: String, i: Int) = getHashThatStartsWithFiveZeros(str, index)
      password += hash.substring(5,6)
      index = i + 1
    }
    password
  }

}
