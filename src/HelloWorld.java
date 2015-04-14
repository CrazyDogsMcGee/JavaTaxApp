import java.io.*;

public class HelloWorld{

     public static void main(String []args){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        PrintStream originalOut = System.out;
       
        System.setOut(ps);
        
        System.out.println("Nonono");
 
        System.out.flush();
        System.setOut(originalOut);
        
        System.out.println(ps.toString());
//     ByteArrayOutputStream baos = new ByteArrayOutputStream();
//     PrintStream ps = new PrintStream(baos);
//     // IMPORTANT: Save the old System.out!
//     PrintStream old = System.out;
//     // Tell Java to use your special stream
//     System.setOut(ps);
//     // Print some output: goes to your special stream
//     System.out.println("Foofoofoo!");
//     // Put things back
//     System.out.flush();
//     System.setOut(old);
//     // Show what happened
//     System.out.println("Here: " + baos.toString());
     }
}

//http://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java