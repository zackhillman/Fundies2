import java.awt.Color;
import tester.*;

class Ball {
  int x;
  int y;
  int radius;
  Color color;

  Ball(int x, int y, int radius, Color color) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = color;
  }

  // Returns the area of this ball
  double area() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  // Returns the circumference of this ball
  double circumference() {
    return 2 * Math.PI * this.radius;
  }
  
  // Returns the distance between each Ball's center
  double distanceTo(Ball thatBall) {
   return Math.sqrt(Math.pow((this.x + thatBall.x),2) - (Math.pow((this.y + thatBall.y),2)));
  }
  
  // Determines if the ball overlaps with another given Ball
  boolean overlaps(Ball thatBall) {
   double distance = distanceTo(thatBall);
   double reaching = this.radius + thatBall.radius;
   return distance < reaching;
  }

}

class ExamplesBall {
  Ball b1 = new Ball(0, 0, 5, Color.BLUE);
  Ball b2 = new Ball(7, 9, 5, Color.RED);
  Ball b3 = new Ball(1, 1, 1, Color.GREEN);

  boolean testBalls(Tester t) {
    return  t.checkExpect(b1.overlaps(b3), true);
  }
}