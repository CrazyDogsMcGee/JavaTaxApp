import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class SalesTaxAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
      System.setOut(originalOut);
    }

    @Test
    public void testInput1() throws IOException {
      try {
        SalesTaxApp.main(new String[] {"../test/testinput1.txt"});
      }
      catch (IOException e) {
        System.setOut(originalOut);
        System.out.println(e);
      }
      assertEquals("1 book: 12.49\n1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.50\nTotal: 29.83\n",outContent.toString());
    }

    @Test
    public void testInput2() throws IOException {
      try {
        SalesTaxApp.main(new String[] {"../test/testinput2.txt"});
      }
      catch (IOException e) {
        System.setOut(originalOut);
        System.out.println(e);
      }
      assertEquals("1 imported box of chocolates: 10.50\n1 imported bottle of perfume: 54.65\nSales Taxes: 7.65\nTotal: 65.15\n", outContent.toString());
    }
  
    /**
     * For this particular test case the word "imported" seems to have been moved.
     * Instead of starting with the word "imported" like in the second case, it has been moved to the back
     * It is unknown whether this was deliberate or not.
     * If it was deliberate, it is unclear in what situations 
    */
  
    @Test
    public void testInput3() throws IOException {
      try {
        SalesTaxApp.main(new String[] {"../test/testinput3.txt"});
      }
      catch (IOException e) {
        System.setOut(originalOut);
        System.out.println(e);
      }
      assertEquals("1 imported bottle of perfume: 32.19\n1 bottle of perfume: 20.89\n1 packet of headache pills: 9.75\n1 imported box of chocolates: 11.85\nSales Taxes: 6.70\nTotal: 74.68\n", outContent.toString());
    }
}