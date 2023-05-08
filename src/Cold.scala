import hevs.graphics.TurtleGraphics


trait aDrawer {
  val aColdTriangle = new TurtleGraphics(600, 600, "ColdTriangle")


  def drawerReallyLittleTriangle(d:Double):Unit = {

  }
  def drawerLittleTriangle(d:Double): Unit = {
    if (d > 1){
      aColdTriangle.turn(-60)
      aColdTriangle.forward(20)
      aColdTriangle.turn(120)
      aColdTriangle.forward(20)
    }
  }
  def drawerMainTriangle(d: Double): Unit = {
    if (d > 0) {
      aColdTriangle.forward(20)
      drawerLittleTriangle(d-1)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(20)
      aColdTriangle.turn(120)
      aColdTriangle.forward(20)
      drawerLittleTriangle(d-1)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(20)
      aColdTriangle.turn(120)
      aColdTriangle.forward(20)
      drawerLittleTriangle(d-1)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(20)
    }


  }
}
object ColdTriangle extends App with aDrawer {

  drawerMainTriangle(3)



}
