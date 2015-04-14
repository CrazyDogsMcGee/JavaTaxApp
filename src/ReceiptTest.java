import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiptTest {
  private List<Good> goodsList = new ArrayList<Good>();
  private Good testGood1;
  private Good testGood2;
  private Good testGood3;
  private Good testGood4;
  private Receipt testReceipt;
  
  @Before
  public void createReceipt() {
    testGood1 = new Good(1,"hat",1.00);
    testGood2 = new Good(1,"imported hat",1.00);
    testGood3 = new Good(1,"chocolate hat",1.00);
    testGood4 = new Good(1,"imported chocolate hat",1.00);
    
    goodsList.add(testGood1);
    goodsList.add(testGood2);
    goodsList.add(testGood3);
    goodsList.add(testGood4);

    testReceipt = new Receipt(goodsList);
  }
  
  //The different getGoodTests are less-than-ideal because they use methods tested in another area to return values. Ought to be refactored or the attributes exposed via reflection

  @Test
  public void getGoodTest() {
    Good item = testReceipt.getGood(0);
    assertEquals("A hat should be 1.10", 1.10 , item.getPrice() , 0.001);
    assertEquals("Should have quantity of 1",1,item.getQuantity());
    assertEquals("Name is hat", "hat", item.getName());
  }
  
  @Test
  public void getTaxExemptGoodTest() {
    Good item = testReceipt.getGood(2);
    assertEquals("A chocolate hat should be 1.00",1.00,item.getPrice(),0.001);
    assertEquals("Should have quantity of 1",1,item.getQuantity());
    assertEquals("Name is chocolate hat","chocolate hat",item.getName());
  }
  
  @Test
  //This method reveals an interesting edge case, there is a very small trailing decimal that causes this method to fail. Need to refactor method in receipt method...
  public void getImportedGoodTest() {
    Good item = testReceipt.getGood(1);
    assertEquals("An imported hat should be 1.15",1.15,item.getPrice(), 0.001);
    assertEquals("Should have quantity of 1",1,item.getQuantity());
    assertEquals("Name is imported hat","imported hat",item.getName());
  }
  
  @Test
  public void getImportedTaxExemptGoodTest() {
    Good item = testReceipt.getGood(3);
    assertEquals("A chocolate imported hat should be 1.05",1.05,item.getPrice(), 0.001);
    assertEquals("Should have quantity of 1",1,item.getQuantity());
    assertEquals("Name is imported chocolate hat","imported chocolate hat",item.getName());
  }
  
  @Test
  public void getTotalTaxTest() {
    assertEquals("Sales tax should be 0.30",0.30,testReceipt.getTotalTax(),0.001);
  }
  
  @Test 
  public void getTotalTest() {
    assertEquals("Total price should be 4.35",4.35,testReceipt.getTotal(),0.001);
  }
}