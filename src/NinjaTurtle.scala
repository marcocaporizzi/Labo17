import hevs.graphics.TurtleGraphics


object NinjaTurtle extends App {

  val aPerfectTriangle = new TurtleGraphics(600, 600, "Triangle")
  aPerfectTriangle.turn(270)
  for ( i <- 0 until 3) {
    aPerfectTriangle.forward(200)
    aPerfectTriangle.turn(120)
  }

  val aPerfectCircle = new TurtleGraphics(600, 600, "Circle")
  for ( i <- 0 until 72) {
    aPerfectCircle.forward(10)
    aPerfectCircle.turn(5)
  }
}
