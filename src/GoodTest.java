import static org.junit.Assert.*;
import org.junit.*;

public class GoodTest {
  private Good testGood;
  
  @Before
  public void createTestGood() {
    testGood = new Good(3, "bottles of oxiclean", 19.95);
  }
  
  @Test
  public void testGoodPrice() {
    double price = 19.95;
    assertEquals("Price of good is 19.95", price, testGood.getPrice(), 0.001);
  }
  
  @Test
  public void testGoodQuantity() {
    int quantity = 3;
    assertEquals("Quantity of good is 3", quantity, testGood.getQuantity());
  }
  
  @Test
  public void testGoodName() {
    String name = "bottles of oxiclean";
    assertEquals("Name of good is 'bottles of oxiclean'",name,testGood.getName());
  }
}