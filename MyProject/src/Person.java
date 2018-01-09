import tester.*;

class Person {

  String name;
  int age;
  String gender;
  
   Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }
  
}

class ExamplesPerson{
  Person tim = new Person("Tim", 20 , "M");
}
