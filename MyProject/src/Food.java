import tester.*;

interface IFood {
}

class Soup implements IFood {
  String name;
  int price;

  boolean vegetarian;

  Soup(String name, int price, boolean vegetarian) {
    this.name = name;
    this.price = price;
    this.vegetarian = vegetarian;
  }

}

class Salad implements IFood {

  String name;
  int price;

  boolean vegetarian;

  String dressing;

  Salad(String name, int price, boolean vegetarian, String dressing) {
    this.name = name;
    this.price = price;
    this.vegetarian = vegetarian;
    this.dressing = dressing;
  }

}

class Sandwich implements IFood {

  String name;
  int price;

  String breadType;
  String firstFilling;
  String secondFilling;

  Sandwich(String name, int price, String breadType, String firstFilling, String secondFilling) {
    this.name = name;
    this.price = price;
    this.breadType = breadType;
    this.firstFilling = firstFilling;
    this.secondFilling = secondFilling;
  }

}

class ExamplesFood {

  IFood soup1 = new Soup("Clam", 123, false);
  IFood soup2 = new Soup("Apple", 1, true);
  
  IFood salad1 = new Salad("Ceasar", 34, true, "Ranch");
  IFood salad2 = new Salad("Garden", 12, false, "Balsamic");
  
  IFood sandwich1 = new Sandwich("BLT", 3, "Italien", "Bacon", "Lettuce");
  
}
