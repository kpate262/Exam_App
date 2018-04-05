import java.util.*;
import java.io.*;

public class MCSAQuestion extends MCQuestion{

  public MCSAQuestion(String text, double maxValue){
    super(text, maxValue);
  }

  public MCSAQuestion(Scanner scan) {
	  super(scan);
	  int numAnswers = Integer.parseInt(scan.nextLine());
	  
	  while(numAnswers != 0) {
		  answers.add( new MCSAAnswer(scan) );
		  numAnswers--;
	  }
  }

  public Answer getNewAnswer(){
	  Answer answer = new MCSAAnswer(" ", 0.0);
	  return answer;
  }


  public Answer getNewAnswer(String text, double creditIfSelected){
	  Answer answer = new MCSAAnswer(text, creditIfSelected);
	  return answer;
  }


  public void getAnswerFromStudent(){
    //Scanner scan = new Scanner(System.in);
	 Scanner scan = ScannerFactory.getKeyboardScanner();
    char in = scan.findInLine(".").charAt(0);
    char toUpper = Character.toUpperCase(in);
    int t = toUpper - 65;

    studentAnswer = answers.get(t);
    return;
  }


  public double getValue(){
	  double score = ((MCAnswer)studentAnswer).getCredit(rightAnswer) *super.maxValue;
	  return score;
  }
  
  
  public void save(PrintWriter writer) {
	  writer.write("" + super.maxValue + "\r\n");
	  writer.write(super.text + "\r\n");
	  writer.write(answers.size()+"\r\n");
	  
	  int size = answers.size();
	  int i = 0;
	  
	  while(i != size) {
		  ((MCAnswer)answers.get(i)).save(writer);
		  i++;
	  }
	  
  }


	
	@Override
	public void restoreStudentAnswers(Scanner scan) {
		studentAnswer = new MCSAAnswer(scan);
	}




}
