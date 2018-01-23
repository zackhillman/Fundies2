import tester.*;

interface IWinterOutfit {}

class BaseLayer implements IWinterOutfit {
  String name;

  BaseLayer(String name) {
    this.name = name;
  }
}

class Covering implements IWinterOutfit {
  IWinterOutfit inner;
  String description;

  Covering(IWinterOutfit inner, String description) {
    this.inner = inner;
    this.description = description;
  }
}

class ExamplesWinterOutfit {

  IWinterOutfit leggings = new BaseLayer("leggings");
  IWinterOutfit sweatpants = new Covering(leggings, "sweatpants");
  IWinterOutfit skiPants = new Covering(sweatpants, "ski pants");
  IWinterOutfit skiing = new Covering(skiPants, "boots");

  IWinterOutfit shirt = new BaseLayer("shirt");
  IWinterOutfit vest = new Covering(shirt, "vest");
  IWinterOutfit jacket = new Covering(vest, "suit jacket");
  IWinterOutfit coat = new Covering(jacket, "top coat");
  IWinterOutfit formalwear = new Covering(coat, "scarf");

}