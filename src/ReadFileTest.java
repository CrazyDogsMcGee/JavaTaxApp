import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;

public class ReadFileTest {
  private ReadFile testReadFile;
  private String[] testStringArray;
  
  @Before
  public void createFileReader() {
    testReadFile = new ReadFile("../test/readfiletest.txt");
  }
  
  @Test
  public void fileReadStringArray() throws IOException {
    try{
    testStringArray = testReadFile.openFile();
    }
    catch (IOException e){
      System.out.println(e);
    }
    String[] correctOutput = {"Line 1","Line 2","Line 3"};
    assertArrayEquals("Creates String array from readfiletest.txt", correctOutput, testStringArray);
  }
}