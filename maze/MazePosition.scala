package maze

object MazePosition extends Enumeration {
  type Type = Value
  val Wall = Value("W")
  val Free = Value("F")
  val Taken = Value("T")

  def toTerminal(value: String): String = {
    value match {
      case "W" => "███"
      case "F" => "   "
      case "T" => " \u001B[32m•\u001B[0m "
    }
  }
}