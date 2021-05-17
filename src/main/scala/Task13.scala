package ru.shepelevkirill.kp

/**
 * Дана строка содержащая только цифры. Восстановите ее, вернув все возможные допустимые комбинации IP-адресов.
 *
 * Действительный IP-адрес состоит ровно из четырех целых чисел, каждое целое число находится в диапазоне от 0 до 255,
 * разделенных одиночными точками и не может иметь нулей в начале кроме самого числа 0.
 * Например, «0.3.14.221» и «192.168.0.1» - допустимые IP-адреса,
 * а «0.033.255.247», «192.168.0.299» и «192.168@0.1» - недопустимые IP-адреса.
 *
 * 0 <= s.length <= 3000
 * Строка состоит только из цифр.
 */
object Task13 {
  def solution(s: String): List[String] = {
    def separate(s: String): Array[String] =
      (for (a <- 1 to s.length.min(3)) yield s.substring(0, a)).toArray

    def isValidIp(ip: String): Boolean = {
      ip.length <= 15 && ip.count(_ == '.') == 3 && ip.split('.').forall { part =>
        val partInt = part.toInt

        if (part.length > 3 || partInt < 0 || partInt > 255) false
        else if (part.length > 1 && partInt == 0) false
        else if (part.length > 1 && partInt != 0 && part(0) == '0') false
        else true
      }
    }

    def tree(s: String, separations: Seq[String]): Seq[String] = {
      val nextSeparations = for (separation <- separations) yield {
        val separationLength = separation.filterNot(_ == '.').length
        if (separationLength == s.length) {
          Left(separation)
        } else {
          val remainingString = s.drop(separationLength)
          Right((separation, separate(remainingString)))
        }
      }

      nextSeparations
        .flatMap { result =>
          result match {
            case Left(separation) => Seq(separation)
            case Right((separation, separations)) => tree(s, separations.map(separation + '.' + _))
          }
        }
    }

    if (s.length <= 12) {
      tree(s, separate(s))
        .filter(isValidIp)
        .toList
    } else {
      List.empty
    }
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

  println(s"Task 13 = ${solution("2552551113500001111010010101023")}")
  // Task 13 = List()
}
