// to represent an ancestor tree
interface IAT {
}

// to represent an unknown member of an ancestor tree
class Unknown implements IAT {
  Unknown() {
  }
}

// to represent a person with the person's ancestor tree
class PersonV2 implements IAT {
  String name;
  int age;
  String gender;
  IAT mom;
  IAT dad;

  PersonV2(String name, int age, String gender, IAT mom, IAT dad) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.mom = mom;
    this.dad = dad;
  }

}

class ExamplesTrees{
  IAT dne = new Unknown(); 
  IAT lerner = new PersonV2("lerner", 12, "M", dne, dne); 
  IAT bob = new PersonV2("Bob", 34, "W", lerner, dne);
}