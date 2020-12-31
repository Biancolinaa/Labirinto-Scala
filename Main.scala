import solver._
import maze._

object Main {
    val F = MazePosition.Free
    val W = MazePosition.Wall

    val maze = Array(
        Array(F, W, W, W),
        Array(F, F, W, F),
        Array(W, F, W, W),
        Array(F, F, F, F)
    )
    def main(args: Array[String]): Unit = {
        val init = Coords(0, 0)
        val end = Coords(3, 3)
        val solver = new MazeSolver(maze, init, end)

        solver.printMaze()

        println("-----------")

        solver.solveAndPrint()
    }
}