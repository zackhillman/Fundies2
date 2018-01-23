//Notes: Having a method that takes in a "part" of a data definition should feel wrong
//ie: taking in a Person

interface IAT {
  IAT youngestGrandparent();
  IAT youngestInGen(int gen);
  IAT youngerAnc(IAT other);
  boolean isWellFormed();
  boolean bornBefore(int other);
}


class Unknown implements IAT {

  @Override
  public IAT youngestGrandparent() {
    return this;
  }

  public boolean isWellFormed() {
    return true;
  }

  public boolean bornBefore(int other) {
    return true;
  }

  public IAT youngestInGen(int gen) {
    return this;
  }

  public IAT youngerAnc(IAT other) {
    return other;
  }
}

class Person implements IAT {
  IAT mom;
  IAT dad;
  
  String name;
  int yob;
  
  Person(IAT mom, IAT dad, String name, int yob) {
    this.mom = mom;
    this.dad = dad;
    this.name = name;
    this.yob = yob;
  }
  
  @Override
  public IAT youngestGrandparent() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public boolean isWellFormed() {
    return (this.mom.bornBefore(this.yob) && this.dad.bornBefore(this.yob) 
        && this.mom.isWellFormed() && this.dad.isWellFormed());
  }

  public boolean bornBefore(int other) {
    return (this.yob < other);
  }

  @Override
  public IAT youngestInGen(int gen) {
    if (gen == 0) {
      return this;
    }
    else {
      return this.mom.youngestInGen(gen-1).youngerAnc(this.dad.youngestInGen(gen-1));
    }
  }

  @Override
  public IAT youngerAnc(IAT other) {
    if (other.bornBefore(this.yob)) {
      return this;
    }
    else { 
      return other;
    }
  }
}






