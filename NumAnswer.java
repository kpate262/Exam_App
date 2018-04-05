import java.util.*;
import java.io.*;

public class NumAnswer extends Answer{
  protected double answer;
  protected double tolerance;

  public NumAnswer(String text, double tolerance){
    answer = Double.parseDouble(text);
    this.tolerance = tolerance;
  }

  public NumAnswer(Scanner scan){
    super(scan);
    String text = scan.nextLine();
    answer = Double.parseDouble(text);
    text = scan.nextLine();
    this.tolerance = Double.parseDouble(text);
  }

  public void print(){
    System.out.println(answer);
  }

  public double getCredit(Answer rightAnswer){
	  Double ans;
	  if(rightAnswer instanceof NumAnswer) {
		 ans = ((NumAnswer)rightAnswer).answer;
     double possibleAnsA = ans + tolerance;
     double possibleAnsb = ans - tolerance;
		 if(answer >= possibleAnsb || answer <= possibleAnsA) {
			 return 1.0;
		 }
	  }
	  return 0.0;
  }

  public void save(PrintWriter writer) {
	  writer.write(answer+"\r\n");
  }

}
