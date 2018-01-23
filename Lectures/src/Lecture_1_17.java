//// ILoBook : sortByAuthor();
//// ConsLoBook implements ILoBook : Book first ILoBook rest
//// MtLoBook implements ILoBook
//
////Book : String author, title
//
////Implement sortByAuthor();
//
////int compareTo (String other)
//// < 0  -->  <
//// == 0 -->  same
//// > 0  -->  >
//
////ILoBook sortByAuthor();
////ILoBook insertSortedByAuthor(Book b);
//
//class Book {
//  String author;
//  String title;
//
//  public Book(String author, String title) {
//    this.author = author;
//    this.title = title;
//  }
//
//  public int compareTo(Book b) {
//    return this.author.compareTo(b.author);
//  }
//}
//
//interface ILoBook {
//
//  ILoBook sortByAuthor();
//  ILoBook insertSortedByAuthor(Book b);
//  ILoBook reverse();
//  ILoBook revAcc(ILoBook soFar);
//
//}
//
//class MtLoBook implements ILoBook {
//
//  public ILoBook sortByAuthor() {
//    return new MtLoBook();
//  }
//
//  public ILoBook insertSortedByAuthor(Book b) {
//    return new ConsLoBook(b, this);
//  }
//
//  public ILoBook reverse() {
//   return new MtLoBook();
//  }
//
//  public ILoBook revAcc(ILoBook soFar) {
//    return soFar;
//  }
//}
//
//class ConsLoBook implements ILoBook {
//  Book first;
//  ILoBook rest;
//
//  ConsLoBook(Book first, ILoBook rest) {
//    this.first = first;
//    this.rest = rest;
//  }
//
//  public ILoBook sortByAuthor() {
//    return this.rest.sortByAuthor().insertSortedByAuthor(this.first);
//  }
//
//  public ILoBook insertSortedByAuthor(Book b) {
//    if (this.first.compareTo(b) < 0) {
//      return new ConsLoBook(this.first, this.rest.insertSortedByAuthor(b));
//    }
//    else {
//      return new ConsLoBook(b, this);
//    }
//  }
//
//  public ILoBook reverse() {
//    return this.revAcc(new MtLoBook());
//  }
//
//  public ILoBook revAcc(ILoBook soFar) {
//    return this.rest.revAcc(new ConsLoBook(this.first, soFar));
//  }
//}
//
//class SnocLoBook implements ILoBook{
//  ILoBook front;
//  Book last;
//  
//  SnocLoBook(ILoBook front, Book last) {
//    this.front = front;
//    this.last = last;
//  }
//
//  public ILoBook sortByAuthor() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public ILoBook insertSortedByAuthor(Book b) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public ILoBook reverse() {
//    return new ConsLoBook(this.last, this.front.reverse());
//  }
//
//  public ILoBook revAcc(ILoBook soFar) {
//    return new ConsLoBook(this.last, this.front.revAcc(soFar));
//  }
//}
//
//class AppendLoBook implements ILoBook {
//  ILoBook front;
//  ILoBook back;
//  
//  AppendLoBook(ILoBook front, ILoBook back) {
//    this.front = front;
//    this.back = back;
//  }
//
//  @Override
//  public ILoBook sortByAuthor() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public ILoBook insertSortedByAuthor(Book b) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public ILoBook reverse() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public ILoBook revAcc(ILoBook soFar) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//}
