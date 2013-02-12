package dk.cphbusiness.model;

import java.util.ArrayList;
import java.util.Collection;

public class Basket {
  private Collection<Item> items = new ArrayList<Item>();

  public Basket() { }

  public Collection<Item> getItems() {
    return items;
    }
  
  public void add(Item item) {
    items.add(item);
    }
  
  }
