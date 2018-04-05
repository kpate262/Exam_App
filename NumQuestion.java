import java.util.*;
import java.io.*;

public class NumQuestion extends Question{
  private double tolerance;

  public NumQuestion(String text, double maxValue, double tolerance){
    super(text, maxValue);
    this.tolerance = tolerance;
  }


  public NumQuestion(Scanner scan){
    super(scan);
    rightAnswer = new NumAnswer(scan);
  }


  public Answer getNewAnswer(){
    Answer answer = new NumAnswer("", 0.0);
    return answer;
  }


  public void print() {
	  System.out.println(text);
  }

  public void getAnswerFromStudent(){
    Scanner scan = ScannerFactory.getKeyboardScanner();
	  String in = scan.nextLine();
    studentAnswer = new NumAnswer(in, 0.0);

    return;
  }


  public double getValue(){
    double score = studentAnswer.getCredit(rightAnswer) * super.maxValue;
	  return score;
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
  		studentAnswer = new NumAnswer(scan);
  	}
}
