import java.util.*;
import java.io.*;

public class SAQuestion extends Question{

  public SAQuestion(String text, double maxValue){
	  super(text, maxValue);
  }

  public SAQuestion(Scanner scan) {
	  super(scan);
	  rightAnswer = new SAAnswer(scan);
  }


  public Answer getNewAnswer(){
	  Answer answer = new SAAnswer("");
	  return answer;
  }


  public Answer getNewAnswer(String text){
	  Answer answer = new SAAnswer(text);
	  return answer;
  }


  public void getAnswerFromStudent(){
	  Scanner scan = ScannerFactory.getKeyboardScanner();
	  String in = scan.nextLine();
	  studentAnswer = new SAAnswer(in);

	  return;
  }


  public double getValue(){
	  double score = studentAnswer.getCredit(rightAnswer) * super.maxValue;
	  return score;
  }


  public void print() {
	  System.out.println(text);
  }

  public void save(PrintWriter writer) {
	  writer.write("" + super.maxValue + "\r\n");
	  writer.write(super.text + "\r\n");
	  rightAnswer.save(writer);
  }

@Override
	public void saveStudentAnswer(PrintWriter writer) {
		studentAnswer.save(writer);
	}

	@Override
	public void restoreStudentAnswers(Scanner scan) {
		studentAnswer = new SAAnswer(scan);
	}


}
