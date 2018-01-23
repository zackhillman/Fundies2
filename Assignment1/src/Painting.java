import tester.*;

class Painting {
  String artist;
  String title;
  int year;
  double height;
  boolean restored;

  Painting(String artist, String title, int year, double height, boolean restored) {
    this.artist = artist;
    this.title = title;
    this.year = year;
    this.height = height;
    this.restored = restored;
  }
}

class ExamplesPaintings {
  Painting monaLisa = new Painting("Leonardo da Vinci", "Mona Lisa", 1506, 30.315, true);
  Painting starryNight = new Painting("Vincent van Gogh", "The Starry Night", 1889, 29.016, false);
  Painting waterLilies = new Painting("Claude Monet", "The Starry Night", 1920, 78.74, false);
}