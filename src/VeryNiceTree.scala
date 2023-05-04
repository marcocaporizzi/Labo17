import hevs.graphics.TurtleGraphics
import scala.util.Random
import java.awt.Color

trait TreeDrawer{

  val myLittleTurtle = new TurtleGraphics(600, 600, "Tree")

  def drawBase(d: Double): Unit = {
    myLittleTurtle.setColor(Color.BLACK)
    myLittleTurtle.forward(d)
  }

  def drawBranch(d: Double): Unit = {
    myLittleTurtle.setColor(Color.GREEN)
    myLittleTurtle.forward(d)
  }


  def drawTree(n:Int, length: Double): Unit = {
    if ( n > 1 ) {
      drawBase(length)
      val anAngleSaver = myLittleTurtle.getTurtleAngle
      val aPositionSaver = myLittleTurtle.getPosition
      myLittleTurtle.turn(-30-Random.between(-10,10))
      //left subtree
      drawTree(n - 1, 30+Random.between(-10,-1))

      myLittleTurtle.setAngle(anAngleSaver)
      myLittleTurtle.jump(aPositionSaver.x,aPositionSaver.y)
      myLittleTurtle.penDown
      //right subtree
      myLittleTurtle.turn(30-Random.between(-10,10))
      drawTree(n - 1, 30+Random.between(-10,-1))
    }
    else {
      drawBranch(3)
    }
  }
}

object VeryNiceTree extends App with TreeDrawer {

  drawTree(9,120)
}