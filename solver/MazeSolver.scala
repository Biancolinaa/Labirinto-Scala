package solver

import maze._

class MazeSolver(var maze: Array[Array[MazePosition.Type]], var init: Coords, var end: Coords) extends Maze(maze, init, end) {
  def solveAndPrint(): Unit = {
    val solution = super.solve()
    if (solution.length == 0)
      println("No")
    else
      println(solution)
  }
}