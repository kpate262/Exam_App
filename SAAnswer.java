import java.util.*;
import java.io.*;

public class SAAnswer extends Answer{
  protected String text;

  public SAAnswer(String text){
    this.text = text;
  }


  public SAAnswer(Scanner scan) {
	  super(scan);
	  this.text = scan.nextLine();
  }


  public void print(){
    System.out.println(text);
  }
  

  public double getCredit(Answer rightAnswer){
	  String ans;
	  if(rightAnswer instanceof SAAnswer) {
		 ans = ((SAAnswer)rightAnswer).text;
		 if(ans.equals(this.text)) {
			 return 1.0;
		 }
	  }
	  return 0.0;
  }


  public void save(PrintWriter writer) {
	  writer.write(text+"\r\n");
  }

}
