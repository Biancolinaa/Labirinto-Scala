package maze

import scala.collection.mutable.ListBuffer
import pretty._

class Maze(private var maze: Array[Array[MazePosition.Type]], private var init: Coords, private var end: Coords) extends Prettifiable {
  private  val solution: ListBuffer[Coords] = ListBuffer()
  private val rows = maze.length
  private val cols = maze(0).length
  
  def solve(): List[Coords] = {
    if (solve(init))
      solution.toList
    else
      List()
  }

  private def solve(c: Coords): Boolean = {
    solution += c
    maze(c.x)(c.y) = MazePosition.Taken
    
    if (c.x == end.x && c.y == end.y) {
      return true
    }
    
    
    var c1 = Coords(c.x - 1, c.y)
    if (c.x > 0 && isFree(c1) && solve(c1)) {
      return true
    }
        
    c1 = Coords(c.x + 1, c.y)
    if (c.x < rows - 1 && isFree(c1) && solve(c1)) {
      return true
    }
    
    c1 = Coords(c.x, c.y - 1)
    if (c.y > 0 && isFree(c1) && solve(c1)) {
      return true
    }

    c1 = Coords(c.x, c.y + 1)
    if (c.y < cols - 1 && isFree(c1) && solve(c1)){

        return true
    }
        
    solution -= c
    maze(c.x)(c.y) = MazePosition.Free
    return false
  }

  private def isFree(c: Coords) =
    maze(c.x)(c.y) == MazePosition.Free

  def toPretty(): String = {
    val output = Array.ofDim[String](rows, cols)
    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        output(i)(j) = maze(i)(j).toString()
      }
    }

    for (c <- solution)
      output(c.x)(c.y) = MazePosition.Taken.toString()

    var s = "╔"
    for (i <- 0 until 3*cols) {
      s += "═"
    }
    s += "╗\n"
    s += output.map(row => {
      "║" + row.map(x => MazePosition.toTerminal(x)).mkString + "║"
    }).mkString("\n")
    s += "\n╚"
    for (i <- 0 until 3*cols) {
      s += "═"
    }
    s += "╝\n"

    s
  }
}
