import java.util.Scanner;
import java.io.*;
import java.util.Random;

abstract class Question {
	protected String text;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;

	protected Question(String text, double maxValue) {//constructor
		this.text = text;
		this.maxValue = maxValue;
	}
	
	public Question(Scanner scan) {
		this.maxValue = Double.parseDouble(scan.nextLine());
		this.text = scan.nextLine();
	}
	

	abstract public void print();//prints itself(question) and prints all the Answers


	public void setRightAnswer(Answer ans){
		rightAnswer = ans;
	}


	abstract public Answer getNewAnswer();


	abstract public void getAnswerFromStudent();
	//abstract void reorderAnswers();

	abstract public double getValue();// reports the total score of the question
	
	abstract public void save(PrintWriter writer);
	
	public void saveStudentAnswer(PrintWriter writer) {
		studentAnswer.save(writer);
	}
	
	abstract public void restoreStudentAnswers(Scanner scan);

}
