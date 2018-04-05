import java.util.*;
import java.io.*;


abstract class MCQuestion extends Question{
  protected ArrayList<MCAnswer> answers = new ArrayList<MCAnswer>();// array of objects

  protected MCQuestion(String text, double maxValue){
    super(text, maxValue);
  }
  
  
  protected MCQuestion(Scanner scan) {
	  super(scan);
  }
  

  public void print() {//prints itself(question) and prints all the Answers
		System.out.println(super.text);
		for(int i = 0; i < answers.size(); i++) {
			char t = (char)(i+65);
			System.out.print("  " + t + "). ");
			answers.get(i).print();
		}
  }
  

  
  public void addAnswer(MCAnswer answer) {//calls the Answer class and adds the object of Answer to the answers array
	  answers.add(answer);
  }


  public void reorderAnswers() {// this method shuffles all the answers
		Collections.shuffle(answers);
	}
  
  
  public double getValue(MCAnswer answ) {
	  double score = studentAnswer.getCredit(rightAnswer) * super.maxValue;
	  return score;
  }
  
  
  public void save(PrintWriter writer) {
	  writer.write("" + super.maxValue + "\r\n");
	  writer.write(super.text + "\r\n");
	  
  }
  
}
