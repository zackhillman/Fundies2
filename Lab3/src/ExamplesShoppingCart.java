class ExamplesShoppingCart {
  // FOR THIS LAB ONLY: notice the changed signature
//  boolean testAllCarts(ShoppingCartTester t) {
//    ShoppingCart cart1 = new ShoppingCart().add("apples", 5);
// 
//    return
//         // You can use all the normal tester methods
//         t.checkExpect(cart1.numItems(), 1)
//         // But there are *NEW* methods unique to this lab
//         // Here are some example usages: (write more tests yourself!)
//      && t.testall_NumItems(cart1, 1)
//      && t.testall_ItemCount(cart1, "apples", 1)
//      && t.testall_TotalPrice(cart1, 5);
//         // These methods, and a few more, are documented below
//  }
  
  boolean testAllCartNumItems(ShoppingCartTester t) {
    ShoppingCart cart1 = new ShoppingCart().add("apple", 10);
    ShoppingCart cart2 = new ShoppingCart();
    ShoppingCart cart3 = new ShoppingCart().add("apple", 10).add("apple", 10);
    ShoppingCart cart4 = new ShoppingCart().add("apple", 10).removeEverything();
    ShoppingCart cart5 = new ShoppingCart().add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart6 = new ShoppingCart().add("apple", 10).removeItem("apple", 0);
    ShoppingCart cart7 = new ShoppingCart().add("apple", 10).removeItem("bannana",1 );
    ShoppingCart cart8 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart9 = new ShoppingCart().removeItem("apple", 2).add("apple", 10);

    return t.testall_NumItems(cart1, 1)
        && t.testall_NumItems(cart2, 0)
        && t.testall_NumItems(cart3, 2)
        && t.testall_NumItems(cart4, 0)
        && t.testall_NumItems(cart5, 0)
        && t.testall_NumItems(cart6, 1)
        && t.testall_NumItems(cart7, 1)
        && t.testall_NumItems(cart8, 1)
        && t.testall_NumItems(cart9, 1);
  }
  
  boolean testAllItemCount(ShoppingCartTester t) {
    ShoppingCart cart1 = new ShoppingCart().add("apple", 10);
    ShoppingCart cart2 = new ShoppingCart();

    ShoppingCart cart3 = new ShoppingCart().add("apple", 10).add("apple", 10);
    ShoppingCart cart4 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart5 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1).add("orange", 3);
    ShoppingCart cart6 = new ShoppingCart().add("apple", 10).removeEverything();
    ShoppingCart cart7 = new ShoppingCart().removeEverything();
    ShoppingCart cart9 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 4);
    ShoppingCart cart11 = new ShoppingCart().add("apple", 10).add("apple", 12).removeEverything();
    
    return t.testall_ItemCount(cart1, "apple", 1)
        && t.testall_ItemCount(cart1, "orange", 0)
        && t.testall_ItemCount(cart2, "apple", 0)
        && t.testall_ItemCount(cart3, "apple", 2)
        && t.testall_ItemCount(cart4, "apple", 1)
        && t.testall_ItemCount(cart5, "apple", 1)
        && t.testall_ItemCount(cart6, "apple", 0)
        && t.testall_ItemCount(cart7, "pear", 0)
        && t.testall_ItemCount(cart9, "apple", 0)
        && t.testall_ItemCount(cart11, "apple", 0);
  }
  
  boolean testAllTotalPrice(ShoppingCartTester t) {
    ShoppingCart cart1 = new ShoppingCart().add("apple", 10);
    ShoppingCart cart2 = new ShoppingCart();
    ShoppingCart cart3 = new ShoppingCart().add("apple", 10).add("apple", 10);
    ShoppingCart cart4 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart5 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1).add("orange", 3);
    ShoppingCart cart6 = new ShoppingCart().add("apple", 10).removeEverything();
    ShoppingCart cart7 = new ShoppingCart().add("apple", 10).add("orange", 10).removeEverything();
    
    ShoppingCart cart8 = new ShoppingCart().add("apple", 0);
    ShoppingCart cart9 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 4);
    ShoppingCart cart10 = new ShoppingCart().add("apple", 10).add("apple", 10).removeEverything();
    ShoppingCart cart11 = new ShoppingCart().add("apple", 10).add("apple", 15).add("pear", 10);
    
    
    
    return t.testall_ItemCount(cart1, "apple", 1)
        && t.testall_TotalPrice(cart1, 10)
        && t.testall_TotalPrice(cart2, 0)
        && t.testall_TotalPrice(cart3, 20)
        && t.testall_TotalPrice(cart4, 10)
        && t.testall_TotalPrice(cart5, 13)
        && t.testall_TotalPrice(cart6, 0)
        && t.testall_TotalPrice(cart7, 0)
        && t.testall_TotalPrice(cart8, 0)
        && t.testall_TotalPrice(cart9, 0)
        && t.testall_TotalPrice(cart10, 0)
        && t.testall_TotalPrice(cart11, 35);
        
  }
  
  boolean testSingNumItems(ShoppingCartTester t) {
    //Bug 0: Doesn't account for Items of the same name
    ShoppingCart cart0 = new ShoppingCart().add("apple", 10).add("apple", 10).add("apple", 10);
    ShoppingCart cart01 = new ShoppingCart().add("apple", 10).add("pear", 10);
    
    ShoppingCart cart1 = new ShoppingCart().add("apple", 10);
    ShoppingCart cart2 = new ShoppingCart();

    ShoppingCart cart4 = new ShoppingCart().add("apple", 10).removeEverything();
    ShoppingCart cart5 = new ShoppingCart().add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart6 = new ShoppingCart().add("apple", 10).removeItem("apple", 0);
    ShoppingCart cart7 = new ShoppingCart().add("apple", 10).removeItem("bannana",1 );
    ShoppingCart cart8 = new ShoppingCart().add("apple", 10).add("apple", 10).removeItem("apple", 1);
    ShoppingCart cart9 = new ShoppingCart().removeItem("apple", 2).add("apple", 10);
    
    return  t.testone_NumItems(0, cart0, 3)
        &&  t.testone_NumItems_works(0, cart01, 2)
        
        && t.testone_NumItems(2, cart1, 1);
        
       
  }
}