I cimport java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
  private List<Good> goodsList;
  
  public Receipt(List<Good> goods) {
    goodsList = goods;
  }
  
  public List<Good> getList() {
    return goodsList;
  }
  
  public Good getGood(int index) {
    Good goodBeforeTax = this.goodsList.get(index);
    double afterTax;
    
    afterTax = goodBeforeTax.getPrice() + getTax(goodBeforeTax);
    double afterQuantity = afterTax * goodBeforeTax.getQuantity();
    
    return new Good(goodBeforeTax.getQuantity(), goodBeforeTax.getName(),afterQuantity);
  }
  
  public double getTotalTax() {
    double totalTax = 0;
    
    for (int i=0;i<goodsList.size();i++) {
      Good listItem = goodsList.get(i);
      totalTax += getTax(listItem);
    }
    
    return totalTax;
  }
  
  public double getTotal() {
    double totalPrice = 0;
    
    for (int i=0;i<goodsList.size();i++) {
      Good listItem = goodsList.get(i);
      totalPrice += listItem.getPrice();
    }
    
    return totalPrice + getTotalTax();
  }
  
  //The methods below are more like utility methods
  
  private double getTax(Good item) {
    double tax = 0;
    
    if (isImported(item.getName())) {
      tax += (item.getPrice() * 0.05);
    }
    
    if (isTaxable(item.getName())) {
      tax += (item.getPrice() * 0.10);
    }
    
    tax = (double) Math.ceil(tax*20.0)/20.0;
    
    return tax;
  }
  
  private boolean isImported(String name) {
    return name.contains("imported");
  }
  
  private boolean isTaxable(String name) {
    Pattern taxExemptKeywords = Pattern.compile("chocolate|pill|book");
    Matcher hasExemptWords = taxExemptKeywords.matcher(name);
    
    return !hasExemptWords.find();
  }
}