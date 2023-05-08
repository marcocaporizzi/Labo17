import hevs.graphics.TurtleGraphics
import sun.security.util.Length


trait aDrawer {
  val aColdTriangle = new TurtleGraphics(600, 600, "ColdTriangle")

  def drawerReallyLittleTriangle(d:Double,length: Double):Unit = {
  }
  def drawerLittleTriangle(d:Double, length: Double): Unit = {
    if (d > 1){
      aColdTriangle.turn(-60)
      aColdTriangle.forward(length)
      aColdTriangle.turn(120)
      aColdTriangle.forward(length)
    }
  }
  def drawerMainTriangle(d: Double, length: Double): Unit = {
    if (d > 0) {
      aColdTriangle.forward(length)
      drawerReallyLittleTriangle(d-1,length)
      drawerLittleTriangle(d-1,length)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(length)
      aColdTriangle.turn(120)
      aColdTriangle.forward(length)
      drawerLittleTriangle(d-1,length)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(length)
      aColdTriangle.turn(120)
      aColdTriangle.forward(length)
      drawerLittleTriangle(d-1, length)
      aColdTriangle.turn(-60)
      aColdTriangle.forward(length)
    }


  }
}

class Triangle {
  val myTurtle = new TurtleGraphics(600, 600, "Snowflake")
  val initialPosition = myTurtle.getPosition
  def MainTriangle(d: Double, length: Double, level: Double): Unit = {
    if (d > 0) {
      myTurtle.forward(length)
      myTurtle.turn(120)
      MainTriangle(d-1, length, level)
    }
  }

  def checker ( value: Boolean, level:Double) = {
    var checker: Boolean = true
    if (checker == true || level%2==1 ) {
      myTurtle.turn(30)
      checker = !checker
    }
    else {
      myTurtle.turn(-210)
      checker = !checker
    }
  }
  def ImportantPiece( d: Double, length: Double, level:Double ): Unit = {
    if ( d > 0 ) {
      myTurtle.forward(length / level)
      myTurtle.turn(-60)
      myTurtle.forward(length / level)
      myTurtle.turn(120)
      myTurtle.forward(length / level)
      myTurtle.turn(-60)
      myTurtle.forward(length / level)
      myTurtle.setAngle(0)
      checker(true,level)
      myTurtle.forward(length / level)
      myTurtle.turn(-60)
      myTurtle.forward(length / level)
      myTurtle.turn(120)
      myTurtle.forward(length / level)
      myTurtle.turn(-60)
      myTurtle.forward(length / level)
      myTurtle.setAngle(0)
      myTurtle.forward(length/level)
    }



  }
}
object ColdTriangle extends App with aDrawer {

 val mainDrawing = new Triangle()
 mainDrawing.ImportantPiece(3,50, 2)



}
