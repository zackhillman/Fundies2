import tester.*;

//An ILoFeature is one of:
// - MtLoFeature
// - ConsLoFeature
//It is the interface for our Lists of IFeatures
interface ILoFeature {

  int totalCapcity();

  double totalRating();

  double restaurantCount();

  String restaurantInfo();

}

// This represents the empty list of IFeature
class MtLoFeature implements ILoFeature {

  /*
   * Fields: N/A Methods: - totalCapcity() - int - totalRating() - double -
   * restaurantCount() - double - restaurantInfo() - String Methods on Fields: N/A
   */

  // This method gets the total capacity of a MtLoFeature (which is 0)
  public int totalCapcity() {
    return 0;
  }

  // This method gets the total rating of a MtLoFeature (which is 0)
  public double totalRating() {
    return 0;
  }

  // This method gets the total restaurant count of a MtLoFeature (which is 0)
  public double restaurantCount() {
    return 0;
  }

  // This method gets the restaurant information for a MtLoFeature (which is
  // nothing)
  public String restaurantInfo() {
    return "";
  }
}

// This class represents a Cons of an IFeature and a ILoFeature
class ConsLoFeature implements ILoFeature {
  IFeature first;
  ILoFeature rest;

  ConsLoFeature(IFeature first, ILoFeature rest) {
    this.first = first;
    this.rest = rest;
  }
  /*
   * Fields: - this.first - IFeature - this.rest - ILoFeature Methods: -
   * totalCapacity() - int - totalRating() - double - restaurantCount() - double -
   * restaurantInfo() - String Methods on Fields: - this.first.totalCapcity() -
   * int - this.first.totalRating() - double - this.first.restaurantCount() -
   * double - this.first.restaurantInfo() - String - this.rest.totalCapcity() -
   * int - this.rest.totalRating() - double - this.rest.restaurantCount() - double
   * - this.rest.restaurantInfo() - String
   */

  // This method gets the total capacity of the list of features
  // It adds the first's capacity and the capacity of the rest
  public int totalCapcity() {
    return this.first.totalCapacityFeature() + this.rest.totalCapcity();
  }

  // This method gets the total rating of the list of features
  // It adds the first's rating and the rating of the rest
  public double totalRating() {
    return this.first.totalRating() + this.rest.totalRating();
  }

  // This method gets the total number of restaurants in the list of features
  public double restaurantCount() {
    return this.first.restaurantCount() + this.rest.restaurantCount();
  }

  // This method gets the information of each restaurant in a list of features
  // It combines the name and the type
  public String restaurantInfo() {
    if (this.rest.restaurantInfo().equals("")) {
      return this.first.restaurantInfo();
    }
    else if (this.first.restaurantInfo().equals("")) {
      return this.rest.restaurantInfo();
    }
    else {
      return this.first.restaurantInfo() + ", " + this.rest.restaurantInfo();
    }

  }
}

// An IFeature is one of:
// - Restaurant
// - Venue
// - ShuttleBus
// It is the interface for our Features
interface IFeature {

  int totalCapacityFeature(); // This method gets the capacity of each feature

  double totalRating(); // This method gets the rating of each feature

  double restaurantCount(); // Determines if the feature is a restaurant and returns 1

  String restaurantInfo(); // Gets the name and type of a restaurant

}

// A Place has a name and a list of features it represents a place on a map
class Place {
  String name;
  ILoFeature features;

  Place(String name, ILoFeature features) {
    this.name = name;
    this.features = features;
  }

  /*
   * Fields: - this.name - String - this.features - ILoFeature Methods: -
   * totalCapacity() - int - foodinessRating() - double - restaurantCount() -
   * double - totalRating() - double - restaurantInfo() - String Methods on
   * Fields: - this.features.totalCapcity() - int - this.features.totalRating() -
   * double - this.features.restaurantCount() - double -
   * this.features.restaurantInfo() - String
   */

  int totalCapacity() {
    return this.features.totalCapcity();
  }

  // Divides total rating and restaurant count
  double foodinessRating() {
    if (this.restaurantCount() == 0) {
      return 0;
    }
    else {
      return (this.totalRating() / this.restaurantCount());
    }
  }

  double restaurantCount() {
    return this.features.restaurantCount();
  }

  double totalRating() {
    return this.features.totalRating();
  }

  String restaurantInfo() {
    return this.features.restaurantInfo();
  }
}

// A Restaurant has a name, type, and averageRating.
// It represents a restaurant in a place's list of features
class Restaurant implements IFeature {
  String name;
  String type;
  double averageRating;

  Restaurant(String name, String type, Double averageRating) {
    this.name = name;
    this.type = type;
    this.averageRating = averageRating;
  }

  /*
   * Fields: - this.name - String - this.type - String - this.averageRating -
   * double Methods: - totalCapacity() - int - foodinessRating() - double -
   * restaurantCount() - double - totalRating() - double - restaurantInfo() -
   * String Methods on Fields: N/A
   */

  public int totalCapacityFeature() {
    return 0;
  }

  public double totalRating() {
    return this.averageRating;
  }

  // Returns 1 since this is a restaurant
  public double restaurantCount() {
    return 1;
  }

  public String restaurantInfo() {
    return this.name + " (" + this.type + ")";
  }
}

// A Venue has a name, type and capactiy
// It represents a venue in a list of features
class Venue implements IFeature {
  String name;
  String type;
  int capacity;

  Venue(String name, String type, int capacity) {
    this.name = name;
    this.type = type;
    this.capacity = capacity;
  }

  /*
   * Fields: - this.name - String - this.type - String - this.capacity - int
   * Methods: - totalCapacity() - int - foodinessRating() - double -
   * restaurantCount() - double - totalRating() - double - restaurantInfo() -
   * String Methods on Fields: N/A
   */

  public int totalCapacityFeature() {
    return this.capacity;
  }

  public double totalRating() {
    return 0;
  }

  public double restaurantCount() {
    return 0;
  }

  public String restaurantInfo() {
    return "";
  }
}

// A ShuttleBus has a name and a destination
// It represents a bus that can transport visitors to different places
class ShuttleBus implements IFeature {
  String name;
  Place destination;

  ShuttleBus(String name, Place destination) {
    this.name = name;
    this.destination = destination;
  }

  /*
   * Fields: - this.name - String - this.destination - Place Methods: -
   * totalCapacity() - int - foodinessRating() - double - restaurantCount() -
   * double - totalRating() - double - restaurantInfo() - String Methods on
   * Fields: N/A
   */

  // Delegates to destination
  public int totalCapacityFeature() {
    return this.destination.totalCapacity();
  }

  // Delegates to destination
  public double totalRating() {
    return this.destination.totalRating();
  }

  // Delegates to destination
  public double restaurantCount() {
    return this.destination.restaurantCount();
  }

  // Delegates to destination
  public String restaurantInfo() {
    return this.destination.restaurantInfo();
  }
}

class ExamplesPlaces {
  IFeature tdGarden = new Venue("TD Garden", "stadium", 19580);
  IFeature mikesPastry = new Restaurant("Mike's Pastry", "cannolis", 4.3);
  ILoFeature empty = new MtLoFeature();
  ILoFeature pastry = new ConsLoFeature(mikesPastry, empty);
  ILoFeature neFeatures = new ConsLoFeature(tdGarden, pastry);
  Place northEnd = new Place("North End", neFeatures);

  IFeature fresh15 = new ShuttleBus("Freshmen-15", northEnd);
  IFeature legalSeaFoods = new Restaurant("Legal Sea Foods", "seafood", 3.9);
  IFeature harvardStadium = new Venue("Harvard Stadium", "football", 30323);
  ILoFeature stadium = new ConsLoFeature(harvardStadium, empty);
  ILoFeature legal = new ConsLoFeature(legalSeaFoods, stadium);
  ILoFeature harvardFeatures = new ConsLoFeature(fresh15, legal);
  Place harvard = new Place("Harvard", harvardFeatures);

  IFeature italyExpress = new ShuttleBus("Little Italy Express", northEnd);
  IFeature auntieAnnes = new Restaurant("Auntie Anne's", "pretzels", 4.0);
  IFeature crimsonCruiser = new ShuttleBus("Crimson Cruiser", harvard);
  IFeature bostonCommon = new Venue("Boston Common", "public", 150000);
  ILoFeature common = new ConsLoFeature(bostonCommon, empty);
  ILoFeature cruiser = new ConsLoFeature(crimsonCruiser, common);
  ILoFeature annes = new ConsLoFeature(auntieAnnes, cruiser);
  ILoFeature seFeatures = new ConsLoFeature(italyExpress, annes);
  Place southStation = new Place("South Station", seFeatures);

  IFeature airportShuttle = new ShuttleBus("airport shuttle", southStation);
  IFeature starbucks = new Restaurant("Starbucks", "coffee", 4.1);
  IFeature quiznos = new Restaurant("Quiznos", "sandwiches", 3.2);
  ILoFeature airShuttle = new ConsLoFeature(airportShuttle, empty);
  ILoFeature star = new ConsLoFeature(starbucks, airShuttle);
  ILoFeature loganFeatures = new ConsLoFeature(quiznos, star);
  Place loganAirport = new Place("Logan airport", loganFeatures);

  boolean testTotalCapacity(Tester t) {
    return t.checkExpect(loganAirport.totalCapacity(), 219483)
        && t.checkExpect(northEnd.totalCapacity(), 19580)
        && t.checkExpect(harvardStadium.totalCapacityFeature(), 30323)
        && t.checkExpect(legalSeaFoods.totalCapacityFeature(), 0)
        && t.checkExpect(empty.totalCapcity(), 0);
  }

  boolean testFoodinessRating(Tester t) {
    return t.checkInexact(loganAirport.foodinessRating(), 3.96, .01)
        && t.checkExpect(mikesPastry.restaurantCount(), 1.0)
        && t.checkExpect(mikesPastry.totalRating(), 4.3)
        && t.checkExpect(loganAirport.restaurantCount(), 6.0)
        && t.checkExpect(loganAirport.totalRating(), 23.8)
        && t.checkExpect(empty.totalRating(), 0.0) && t.checkExpect(empty.restaurantCount(), 0.0)
        && t.checkExpect(bostonCommon.restaurantCount(), 0.0)
        && t.checkExpect(bostonCommon.totalRating(), 0.0);
  }

  boolean testRestaurantInfo(Tester t) {
    return t.checkExpect(loganAirport.restaurantInfo(),
        "Quiznos (sandwiches), Starbucks (coffee), Mike's Pastry (cannolis), "
            + "Auntie Anne's (pretzels), Mike's Pastry (cannolis), Legal Sea Foods (seafood)")
        && t.checkExpect(italyExpress.restaurantInfo(), "Mike's Pastry (cannolis)")
        && t.checkExpect(bostonCommon.restaurantInfo(), "")
        && t.checkExpect(empty.restaurantInfo(), "");

  }
}