package ru.stga.training.selenium.model;

/**
 * Created by serg on 22.05.2017.
 */
public class Product {

  private int size;
  private String quantity;

  public int getSize() {
    return size;
  }

  public Product withSize(int size) {
    this.size = size;
    return this;
  }

  public String getQuantity() {
    return quantity;
  }

  public Product withQuantity(String quantity) {
    this.quantity = quantity;
    return this;
   }
}
