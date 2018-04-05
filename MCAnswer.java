import java.util.Scanner;
import java.io.*;

public abstract class MCAnswer extends Answer{
  protected String text;
  protected boolean selected;
  protected double creditIfSelected;

  protected MCAnswer(String text, double creditIfSelected){
    this.text = text;
    this.creditIfSelected = creditIfSelected;
  }


  public MCAnswer(Scanner scan) {
	  super(scan);
  }


  public void print(){
		System.out.println(text);
  }


  public double getCredit(Answer rightAnswer) {

	  return creditIfSelected;
  }

  public void save(PrintWriter writer) {
	  writer.write(creditIfSelected + " " + text + "\r\n");
  }

  public String getText(){
    return text;
  }

}
