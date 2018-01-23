import tester.*;

interface IResource {}

class Coin implements IResource {
  String material;
  int value;

  Coin(String material, int value) {
    this.material = material;
    this.value = value;
  }
}

class VictoryToken implements IResource {
  String type;
  int value;
  
  VictoryToken(String type, int value) {
    this.type = type;
    this.value = value;
  }
}

class Card implements IResource {
  String instructions;
  boolean grantsBonusActions;
  
  Card(String instructions, boolean grantsBonusActions) {
    this.instructions = instructions;
    this.grantsBonusActions = grantsBonusActions;
  } 
}

interface IAction {}

class Purchase implements IAction {
  int cost; //Must be positive
  IResource item;
  
  Purchase(int cost, IResource item) {
    this.cost = cost;
    this.item = item;
  }
}

class Swap implements IAction {
  //Value of received  must be no more 
  //than 2 greater than value of consumed
  IResource consumed;
  IResource received; 
  
  Swap(IResource consumed, IResource received) {
    this.consumed = consumed;
    this.received = received;
  }
}

class ExamplesGame {
  IResource ducat = new Coin("bronze", 5);
  IResource fortress = new VictoryToken("Fortress", 2);
  IResource mason = new Card("Play only if you have at least 3 victory points", true);
  IResource dime = new Coin("silver", 10);
  IResource castle = new VictoryToken("Castle", 12);
  IResource king = new Card("Play only if you own a castle", false);
  
  IAction purchase1 = new Purchase(5, ducat);
  IAction purchase2 = new Purchase(12, castle);
  IAction swap1 = new Swap(ducat, fortress);
  IAction swap2 = new Swap(castle, dime);
}

