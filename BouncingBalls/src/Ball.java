import tester.Tester;
import java.awt.Color;
import javalib.worldimages.*;
 
class BouncingBall {
  Posn pos;
  Color color;
  int size;
  int dx; // how fast is the ball moving to the right?
  int dy; // how fast is the ball moving downward?
 
  public BouncingBall(Posn pos, Color color, int size, int dx, int dy) {
    this.pos = pos;
    this.color = color;
    this.size = size;
    this.dx = dx;
    this.dy = dy;
  }
 
  // Returns a new BouncingBall that's just like this BouncingBall, but moved
  // by this BouncingBall's dx and dy
  BouncingBall move() {
   this.pos.x += dx;
   this.pos.y += dy;
   return this;
  }
 
  // Returns a new BouncingBall that represents this BouncingBall just after
  // it has bounced off a side wall. Does not actually move the ball
  BouncingBall bounceX() {
    this.dx *= -1;
    return this;
  }
 
  // Like bounceX, except for using the top or bottom walls
  BouncingBall bounceY() {
    this.dy *= -1;
    return this;
  }
 
  // Does the ball collide with a side wall?
  boolean collidesX(Posn topLeft, Posn botRight) {
    double outlineRight = this.pos.x + this.size + this.dx;
    double outlineLeft = this.pos.x - this.size - this.dx;
    
    return (topLeft.x >= outlineLeft) || (botRight.x <= outlineRight);

  }
 
  // Does the ball collide with a top or bottom wall?
  boolean collidesY(Posn topLeft, Posn botRight) {
    double outlineTop = this.pos.y - this.size - this.dy;
    double outlineBot = this.pos.y + this.size + this.dy;
    
    return (topLeft.y >= outlineTop) || (botRight.y <= outlineBot);
  }

  
}
 
class ExamplesBouncingBalls {
  int WIDTH = 300;
  int HEIGHT = 300;
 
  // NOTE: We have provided BouncingWorld for you, in the starter code.
  // We'll see how it works in a few lectures
  boolean testBigBang(Tester t) {
    BouncingWorld w = new BouncingWorld(WIDTH, HEIGHT);
    return w.bigBang(WIDTH, HEIGHT, 0.1);
  }
}