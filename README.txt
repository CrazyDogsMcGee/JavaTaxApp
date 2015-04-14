Jonathan Lee - ThoughtWorks Submission: Problem Two Sales Taxes
==========

Application Information:
- Source code built in codio Online IDE
- Written in Java:
  java version "1.7.0_67"                                                                                            
- Tested with junit ver. 4.12

Instructions:
+++++
To run the application on Unix-like systems:
1) From the command line, cd into the src directory of this application
2) Compile the .java file by entering "javac SalesTaxApp.java"
3) Run the compiled class file with "java SalesTaxApp ../test/testinput1.txt" (Or use any other text file provided, or your own)

To run tests:
1) Download "junit-4.12.jar" and "hamcrest-core-1.3.jar", save these to the "src" directory
2) Compile each test with the command "javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. <TESTJAVANAME>.java"
3) The tests can be run individually with "java -cp junit-4.12.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore <TESTCLASSNAME>"

For the entire testing suite:
2) Compile with "javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. SalesTaxAppTestSuite.java" 
3) Run with "java -cp junit-4.12.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore SalesTaxAppTestSuite"
NOTE - This will run all the tests. But the individual tests will still need to be compiled to class files before the suite compilation will work.

Design Details:
+++++
- There are four main classes, the actual application (SalesTaxApp), Receipt, Good, and a FileReader
- The file reader presents line-by-line information from text files in the form of String arrays
- The Good is an object representation of items on the text list. There are getter methods for each field
- The Receipt applies tax and can calculate the total price of items on its list
- The application class ties together the above-mentioned classes and prints output to the console
- Medicine and Food are classified by matching certain limited keyword to the name of the good.

Design Assumptions:
+++++
- File paths will be provided through command line args
- The formatting of the items in the text file will always be "<Quantity> <Name> at <Price>/n"
- The desired output should be printed to the console.

Date Submitted: 3/2/15