package dk.cphbusiness.model;

public class Item {
  private long id;
  private String name;
  private double price;

  public Item(long id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
    }

  @Override
  public String toString() {
    return String.format("%s %.2f kr", name, price);
    }
  
  public long getId() {
    return id;
    }

  public String getName() {
    return name;
    }

  public double getPrice() {
    return price;
    }
  
  }
