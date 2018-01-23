import java.awt.Color;

//Need accumulator statement and purpose statement for each method.

boolean hasAllAcc(boolean even, boolean odd, boolean fiveten) {
  return this.rest.hasAllAcc(even || this.first.isEven(), odd, fiveten)
      || this.rest.hasAllAcc(even, odd || this.first.isOdd(), fiveten)
      || this.rest.hasAllAcc(even, odd, fiveten || this.first.isBetweenFiveTen());
}

//Doc -> ILoBook -> Sort -> Remove Dupes -> Citations

interface IShape {
  
}

class Rectangle implements IShape{
  int width, height;
  Color color;
  Posn topLeft;
  
  public Rectangle(int width, int height, Color color, Posn topLeft) {
    this.width = width;
    this.height = height;
    this.color = color;
    this.topLeft = topLeft;
  }
}

class Square extends Rectangle {

  public Square(int size, Color color, Posn topLeft) {
    super(size, size, color, topLeft);
  }
  
  
}