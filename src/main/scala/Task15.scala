package ru.shepelevkirill.kp

/**
 * Дана 2D сеточная карта, состоящая из "1" (земля) и "0" (вода). Подсчитайте количество островов.
 * Остров окружен водой и образован соединением соседних земель по горизонтали или вертикали.
 *
 * Все четыре края сетки окружены водой.
 */
object Task15 {
  def solution(grid: Array[Array[Char]]): Int = {
    def markVisited(row: Int, column: Int): Unit = {
      if (row < 0 || row >= grid.length || column < 0 || column >= grid.head.length || grid(row)(column) == '0')
        return // TODO Можно ли здесь использовать return? Задача помечена как done но
               //      но return'ы же вроде бы не юзаем?

      grid(row).update(column, '0')

      markVisited(row + 1, column)
      markVisited(row - 1, column)
      markVisited(row, column + 1)
      markVisited(row, column - 1)
    }

    var islandCount = 0
    for (row <- grid.indices) {
      for (column <- grid(row).indices) {
        if (grid(row)(column) == '1') {
          markVisited(row, column)
          islandCount += 1
        }
      }
    }

    islandCount
  }

  val grid1 = Array(
    Array('1','1','1','1','0'),
    Array('1','1','0','1','0'),
    Array('1','1','0','0','0'),
    Array('0','0','0','0','0')
  )

  println(s"Task 15 = ${solution(grid1)}")
  // Task 15 = 1

  val grid2 = Array(
    Array('1','1','0','0','0'),
    Array('1','1','0','0','0'),
    Array('0','0','1','0','0'),
    Array('0','0','0','1','1')
  )

  println(s"Task 15 = ${solution(grid2)}")
  // Task 15 = 3
}
