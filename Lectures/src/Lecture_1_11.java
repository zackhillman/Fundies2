//import tester.*;
//
////Recursive Unions:
//
///* A FamTree is one of:
// *  - (make-person String int Famtree FamTree)
// *   - 'unknown
//*/
//
////In Java:
//
//interface IFamTree {
//  // Counts # of known ancestors of this family tree
//  int countKnownAncestors();
//  // Counts # of known persons in this family tree
//  int countPersons();
//
//  // Declaration of method but no implementation (inside interface)
//  // Interfaces are promises of behaviors (if class implements interface it must
//  // have implementation of methods)
//
//}
//
//class Person implements IFamTree {
//  // Going to have 4 fields
//  String name;
//  int yob;
//  IFamTree mother;
//  IFamTree father;
//
//  Person(String name, int yob, IFamTree mother, IFamTree father) {
//    this.name = name;
//    this.yob = yob;
//    this.mother = mother;
//    this.father = father;
//  }
//
//  /*
//   * Fields:
//   *  - this.name - String
//   *  - this.yob - int
//   *  - this.mother - IFamTree
//   *  - this.father - IFamTree
//   * Methods:
//   *  - this.countPersons() - int
//   * Methods on Fields
//   *  - this.father.countPersons() - int
//   *  - this.mother.countPersons() - int
//   *  ... rest of the methods
//   */
//  public int countKnownAncestors() {
//    return this.countPersons() - 1;
//  }
//
//  //Counts # of persons in this Person
//  public int countPersons() {
//    return 1 + this.father.countPersons() + this.mother.countPersons();
//    //The . after this is where java decides what type the object is (similar to cond)
//    //Called dynamic dispatch
//  }
//
//  // Include Constructor
//}
//
//class Unknown implements IFamTree {
//
//  
//  public int countKnownAncestors() {
//    return 0;
//  }
//
//  //Counts # of persons in this Unknown
//  public int countPersons() {
//    return 0;
//  }
//}
//
//// Method: Count known ancestors - how many ancestors of a given tree are known
//// Signature: IFamTree -> int
//
//class ExamplesFamTree {
//
//  boolean testCountKnownAncs(Tester t) {
//    IFamTree unk = new Unknown();
//    IFamTree f1 = new Person("A", 2017, unk, unk);
//    IFamTree f2 = new Person("B", -3, f1, unk);
//    return t.checkExpect(unk.countKnownAncestors(), 0) 
//        && t.checkExpect(f1.countKnownAncestors(), 0) 
//        && t.checkExpect(f2.countKnownAncestors(), 1);
//  }
//}