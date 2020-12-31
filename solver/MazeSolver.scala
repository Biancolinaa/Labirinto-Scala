package solver

import maze._

class MazeSolver(var maze: Array[Array[MazePosition.Type]], var init: Coords, var end: Coords) extends Maze(maze, init, end) {
  def solveAndPrint(): Unit = {
    val solution = super.solve()
    if (solution.length == 0)
      println("No")
    else
      printMaze(solution)
  }

  def printMaze(): Unit = {
    printMaze(List())
  }

  private def printMaze(solution: List[Coords]): Unit = {
    val output = Array.ofDim[String](maze.length, maze(0).length)
    for (i <- 0 until maze.length) {
      for (j <- 0 until maze(0).length) {
        output(i)(j) = maze(i)(j).toString()
      }
    }

    for (c <- solution)
      output(c.x)(c.y) = MazePosition.Taken.toString()
    
    output.foreach(row => {
      row.foreach(print)
      println()
    })
  }
}