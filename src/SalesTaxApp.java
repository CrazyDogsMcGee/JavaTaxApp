import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.text.DecimalFormat;

public class SalesTaxApp {
      private static ReadFile inventoryListTxt;
      private static String[] itemArray;
      private static String filePath;
      private static DecimalFormat moneyFormatter = new DecimalFormat("#0.00");
  
  public static void main (String[] args) throws IOException, ArrayIndexOutOfBoundsException {
      try {
        filePath = args[0];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("No file path provided on launch");
      }
        
      try{
        inventoryListTxt = new ReadFile(filePath);
        itemArray = inventoryListTxt.openFile();
      }
      catch (IOException e) {
        System.out.println("No file found");
      }

      int numberOfItems = itemArray.length;
      List<Good> goodsList = new ArrayList<Good>();

      for (int i = 0; i < numberOfItems; i++) {
        Good listGood = createGood(itemArray[i]);
        goodsList.add(listGood);
      }

      Receipt textReceipt = new Receipt(goodsList);

      for (int i = 0; i < numberOfItems; i++) {
        Good lineItem = textReceipt.getGood(i);
        System.out.println(Integer.toString(lineItem.getQuantity()) + " " + lineItem.getName() + ": " + moneyFormatter.format(lineItem.getPrice()));
      }

      System.out.println("Sales Taxes: "+ moneyFormatter.format(textReceipt.getTotalTax()));
      System.out.println("Total: "+moneyFormatter.format(textReceipt.getTotal()));

   }
  
    private static Good createGood (String item) {
      Pattern itemRegex = Pattern.compile("^\\d{1,}|(?<=[\\s])(.*)(?=\\sat)|\\d+.\\d\\d");
      Matcher itemMatcher = itemRegex.matcher(item);

      String[] itemProperties = new String[3];
      for (int i = 0; i < 3; i++) {
        itemMatcher.find();
        itemProperties[i] = itemMatcher.group();
      }
      
      int quantity = Integer.parseInt(itemProperties[0]);
      String name = ensureImportPrefixedName(itemProperties[1]);
      double price = Double.parseDouble(itemProperties[2]);
      
      return new Good(quantity, name, price);
    }
  
   private static String ensureImportPrefixedName (String name) {
     if (name.contains(" imported ")) {
       String importFixedName = "imported " + name.replace(" imported ", " ");
       return importFixedName;
     } else {
       return name;
     }
   }
}



