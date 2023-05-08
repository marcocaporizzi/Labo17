import hevs.graphics.TurtleGraphics


trait aDrawer {
  val aColdTriangle = new TurtleGraphics(600, 600, "ColdTriangle")

  def drawer(d:Double): Unit = {
    aColdTriangle.turn(120)
    aColdTriangle.forward(60)

  }

}

object ColdTriangle extends App with aDrawer {



}
