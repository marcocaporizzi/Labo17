import hevs.graphics.TurtleGraphics
import scala.util.Random
import java.awt.Color

trait TreeDrawer{

  val myLittleTurtle = new TurtleGraphics(600, 600, "Tree")

  def drawBase(d: Double): Unit = {
    myLittleTurtle.setColor(Color.BLACK)
    myLittleTurtle.setWidth(5)
    myLittleTurtle.forward(d)
  }

  def drawBranch(d: Double): Unit = {
    if (d > 1) {
      myLittleTurtle.setColor(Color.PINK)
      val anAngleSaver = myLittleTurtle.getTurtleAngle
      val aPositionSaver = myLittleTurtle.getPosition
      myLittleTurtle.turn(Random.between(-360, 360))
      //left subtree
      drawBranch(d - 1)

      myLittleTurtle.setAngle(anAngleSaver)
      myLittleTurtle.jump(aPositionSaver.x, aPositionSaver.y)
      myLittleTurtle.penDown
      //right subtree
      myLittleTurtle.turn(Random.between(-360, 360))
      drawBranch(d - 1)
    }
    else {
      myLittleTurtle.forward(20)

    }
  }


  def drawTree(n:Int, length: Double): Unit = {
    if ( n > 1 ) {
      drawBase(length-1)
      val anAngleSaver = myLittleTurtle.getTurtleAngle
      val aPositionSaver = myLittleTurtle.getPosition
      myLittleTurtle.turn(Random.between(-90,90))
      //left subtree
      drawTree(n - 1, Random.between(10,30))

      myLittleTurtle.setAngle(anAngleSaver)
      myLittleTurtle.jump(aPositionSaver.x,aPositionSaver.y)
      myLittleTurtle.penDown
      //right subtree
      myLittleTurtle.turn(Random.between(-90,90))
      drawTree(n - 1, Random.between(10,30))

    }
    else {
      drawBranch(20)
    }
  }
}

object VeryNiceTree extends App with TreeDrawer {

  drawTree(5,120)
}