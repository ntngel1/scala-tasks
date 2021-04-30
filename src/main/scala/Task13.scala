package ru.shepelevkirill.kp

object Task13 {
  // TODO Cleanup
  def solution(s: String): List[String] = {
    def separate(s: String): Array[String] = {
      val t = for (a <- 1 to s.length.min(3)) yield s.substring(0, a)
      t.toArray
    }

    def isValidIp(ip: String): Boolean = {
      if (ip.length > 15) return false
      if (ip.count(_ == '.') != 3) return false

      ip.split('.').foreach(part => {
        val partInt = part.toInt
        if (part.length > 3 || partInt < 0 || partInt > 255) return false
        if (part.length > 1 && partInt == 0) return false
        if (part.length > 1 && partInt != 0 && part(0) == '0') return false
      })

      true
    }

    def tree(s: String, separations: Seq[String]): Seq[String] = {
      val nextSeparations = for (separation <- separations) yield {
        if (separation.filterNot(_ == '.').length == s.length) Left(separation)
        else Right((separation, separate(s.drop(separation.filterNot(_ == '.').length))))
      }

      nextSeparations
        .flatMap(result => {
          result match {
            case Left(separation) => Seq(separation)
            case Right((separation, separations)) => tree(s, separations.map(separation + '.' + _))
          }
        })
    }

    tree(s, separate(s))
      .filter(isValidIp)
      .toList
  }

  println(s"Task 13 = ${solution("25525511135")}")
  // Task 13 = List("255.255.11.135", "255.255.111.35")

  println(s"Task 13 = ${solution("0000")}")
  // Task 13 = List("0.0.0.0")

  println(s"Task 13 = ${solution("1111")}")
  // Task 13 = List("1.1.1.1")

  println(s"Task 13 = ${solution("010010")}")
  // Task 13 = List("0.10.0.10", "0.100.1.0")

  println(s"Task 13 = ${solution("101023")}")
  // Task 13 = List("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")
}
