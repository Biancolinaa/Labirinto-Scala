package maze

object MazePosition extends Enumeration {
  type Type = Value
  val Wall = Value("#")
  val Free = Value(" ")
  val Taken = Value("*")
}