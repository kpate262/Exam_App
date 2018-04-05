import java.util.Scanner;
import java.io.*;

public class MCSAAnswer extends MCAnswer{
  public MCSAAnswer(String text, double creditIfSelected){
    super(text, creditIfSelected);
  }
  
  public MCSAAnswer(Scanner scan) {
	  super(scan);
	  super.creditIfSelected = scan.nextDouble();
	  scan.findInLine(".").charAt(0);
	  super.text = scan.nextLine();
  }
}