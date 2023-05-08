import hevs.graphics.TurtleGraphics
import scala.util.Random
import java.awt.Color

trait TreeDrawer{

  val myLittleTurtle = new TurtleGraphics(600, 600, "Tree")

  def drawBase(d: Double): Unit = {
    myLittleTurtle.setColor(Color.orange.darker().darker().darker())
    myLittleTurtle.setWidth(9)
    myLittleTurtle.forward(d)
  }

  def drawBranch(d: Double): Unit = {

    if (d > 1) {
      myLittleTurtle.setColor(Color.red.darker())
      val anAngleSaver = myLittleTurtle.getTurtleAngle
      val aPositionSaver = myLittleTurtle.getPosition
      myLittleTurtle.turn(Random.between(-180, 180))
      //left subtree
      drawBranch(d - 1)

      myLittleTurtle.setAngle(anAngleSaver)
      myLittleTurtle.jump(aPositionSaver.x, aPositionSaver.y)
      myLittleTurtle.penDown
      //right subtree
      myLittleTurtle.turn(Random.between(-180, 180))
      drawBranch(d - 1)
    }
    else {
      myLittleTurtle.forward(Random.between(5,10))

    }
  }


  def drawTree(n:Int, length: Double): Unit = {
    if ( n > 1 ) {
      drawBase(length)
      myLittleTurtle.setWidth(Random.between(3,7))
      val anAngleSaver = myLittleTurtle.getTurtleAngle
      val aPositionSaver = myLittleTurtle.getPosition
      myLittleTurtle.turn(-30-Random.between(-20,20))
      //left subtree
      drawTree(n - 1, 30+Random.between(-15,-10))
      drawBranch(n-1)

      myLittleTurtle.setAngle(anAngleSaver)
      myLittleTurtle.jump(aPositionSaver.x,aPositionSaver.y)
      myLittleTurtle.penDown
      //right subtree
      myLittleTurtle.turn(30-Random.between(-20,20))
      drawTree(n - 1, 30+Random.between(-15,-10))
      drawBranch(n-1)
    }
    else {
      drawBranch(Random.between(5,10))
    }
  }
}

object VeryNiceTree extends App with TreeDrawer {

  drawTree(9,120)
}