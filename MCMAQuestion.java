import java.util.*;
import java.io.*;

public class MCMAQuestion extends MCQuestion{
	protected ArrayList<Answer> studentAnswer = new ArrayList<Answer>();
	public double baseCredit;

	public MCMAQuestion(String text, double maxValue, double basecredit) {
		super(text, maxValue);
		this.baseCredit = baseCredit;
	}


	public MCMAQuestion(Scanner scan) {
		super(scan);
		this.baseCredit = Double.parseDouble(scan.nextLine());
		int numAnswers = Integer.parseInt(scan.nextLine());

		while(numAnswers != 0) {
			answers.add( new MCMAAnswer(scan) );
			numAnswers--;
		}
	}


	public Answer getNewAnswer() {
		Answer answer = new MCMAAnswer(" ", 0.0);
		return answer;
	}


	public Answer getNewAnswer(String text, double creditIfSelected) {
		Answer answer = new MCMAAnswer(text, creditIfSelected);
		return answer;
	}


	public void getAnswerFromStudent() {
		//ScannerFactory sca = new ScannerFactory();
		Scanner scan = ScannerFactory.getKeyboardScanner();
    char in = scan.findInLine(".").charAt(0);
    char toUpper = Character.toUpperCase(in);
    int t = toUpper - 65;
    int i = 0;

    while(t != -17 || i > answers.size()) {
    	System.out.println("You can enter more answers or enter 0 to end");
    	studentAnswer.add(answers.get(t));
    	scan.nextLine();
    	in = scan.findInLine(".").charAt(0);
    	//scan.next();
    	if(in == '0') {
    		break;
    	}
    	toUpper = Character.toUpperCase(in);
    	t = toUpper - 65;
    	i++;
    }

    return;
	}


	public double getValue() {
		double score = 0.0;
		for(int i = 0; i < studentAnswer.size(); i++) {
			score += ((MCAnswer)studentAnswer.get(i)).getCredit(rightAnswer);
		}
		return (score + baseCredit)*super.maxValue;
	}


	public void save(PrintWriter writer) {
		writer.write("" + super.maxValue + "\r\n");
		writer.write(super.text + "\r\n");
		writer.write(baseCredit + "\r\n");
		writer.write(answers.size()+"\r\n");

		int size = answers.size();
		int i = 0;

		while(i != size) {
		  ((MCAnswer)answers.get(i)).save(writer);
		  i++;
		}
	}


	public void saveStudentAnswer(PrintWriter writer) {
		writer.write(studentAnswer.size()+"\r\n");

		int size = studentAnswer.size();
		int i = 0;

		while(i != size) {
		  ((MCAnswer)studentAnswer.get(i)).save(writer);
		  i++;
		}
	}


	public void restoreStudentAnswers(Scanner scan) {
		int i = 0;
		String extractSize = scan.nextLine();
		int size = Integer.parseInt(extractSize);

		while(i != size) {
			studentAnswer.add( new MCMAAnswer(scan) );
			i++;
		}

	}

@Override
	public boolean isStudentAnswerEmpty(){
		if(studentAnswer.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}

@Override
	public void voidStudentAnswer(){
		int i = studentAnswer.size()-1;
		while(studentAnswer.size() != 0){
			studentAnswer.remove(i);
			i--;
		}
	}

}
