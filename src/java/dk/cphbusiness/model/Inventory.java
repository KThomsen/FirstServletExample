package dk.cphbusiness.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
  private Map<Long, Item> items = new HashMap<Long, Item>();

  private void put(Item item) {
    items.put(item.getId(), item);
    }
  
  public Inventory() {
    put(new Item(7, "Whiskey", 100.00));
    put(new Item(17, "Håndcreme", 149.95));
    put(new Item(27, "Appelsin", 5.75));
    put(new Item(37, "Sportsvogn", 500000.00));
    put(new Item(47, "Cykel", 10000.00));
    }

  public Collection<Item> getItems() {
    return items.values();
    }
  
  public Item get(long id) {
    return items.get(id);
    }
  
  }
