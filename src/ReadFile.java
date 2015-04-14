import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class ReadFile {
  private String filepath;
  
  //initializes with file path given, passes from command line args
  public ReadFile (String fp) {
    filepath = fp;
  }
  
  public String[] openFile() throws IOException { //throws IOException to be handled in main application
    
    FileReader fileread = new FileReader(filepath);
    BufferedReader textReader = new BufferedReader(fileread);
    
    int numLines = numberOfLines(filepath);
    String[] textLineArray = new String[numLines];
    
    for (int i = 0; i < numLines; i++) {
      textLineArray[i] = textReader.readLine();
    }
    
    textReader.close();
    return textLineArray;
  }
  
  //finds number of lines to instantiate Array
  private int numberOfLines(String path) throws IOException {
    FileReader targetFile = new FileReader(path);
    BufferedReader textStream = new BufferedReader(targetFile);
    
    String line;
    int lineNumber = 0;
    
    while ((line = textStream.readLine()) != null) {
      lineNumber++;
    }
    textStream.close();
    
    return lineNumber;
  }
  
}