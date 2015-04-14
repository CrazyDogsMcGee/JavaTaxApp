public class Good {
  private double price;
  private int quantity;
  private String name;
  
  //Attributes can only be set in initialize
  public Good(int q, String n, double p) {
    quantity = q;
    name = n;
    price = p;
  }
  
  public double getPrice() {
    return this.price;
  }
  
  public int getQuantity() {
    return this.quantity;
  }
  
  public String getName() {
    return this.name;
  }
}