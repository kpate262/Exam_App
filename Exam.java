import java.io.*;
import java.util.*;
import java.util.Random;

public class Exam {
	public String title;
	private ArrayList<Question> questions = new ArrayList<Question>(); //array of questions objects

	public Exam(String title) {//constructor taking one argument
		this.title = title;
	}

	public Exam(Scanner scan) {
		this.title = scan.nextLine();

		String nString;
		double maxValue;
		while(scan.hasNextLine()) {
			nString = scan.nextLine();
			if(nString.equals("")) {
				continue;
			}

			else if(nString.equals("SAQuestion")) {
				questions.add( new SAQuestion(scan) );
			}

			else if(nString.equals("MCSAQuestion")) {
				questions.add( new MCSAQuestion(scan) );
			}

			else if(nString.equals("MCMAQuestion")) {
				questions.add( new MCMAQuestion(scan) );
			}

			else if(nString.equals("NumQuestion")) {
				questions.add( new NumQuestion(scan) );
			}

		}
	}


	public void print() {// printing all the question and answers
		System.out.println("\t\t\t" + title);
		for(int i = 0; i < questions.size(); i++) {
			System.out.print((i+1) + "). ");
			questions.get(i).print();
		}
	}


	public void addQuestion(Question question) {// adds question taken by string input and added at the end of the array
		questions.add(question);
	}


	public void reorderQuestions() {// shuffles all the questions in the exam
		Collections.shuffle(questions);
	}


	public void reorderMCAnswers(int position) {// shuffles both questions and answers
		int size = questions.size()-1;

		if(position < 0) {
			while(size != -1) {
				if(questions.get(size) instanceof MCQuestion) {
					((MCQuestion)questions.get(size)).reorderAnswers();
				}
				size--;
			}
		}
		else {
			((MCQuestion)questions.get(position)).reorderAnswers();
		}

	}


	public void getAnswerFromStudent(int position) {
		System.out.print(position + "). ");
		questions.get(position-1).print();
		System.out.print("Answer: ");

		if(questions.get(position-1) instanceof MCMAQuestion){
			if(questions.get(position-1).isStudentAnswerEmpty() == true){
				questions.get(position-1).getAnswerFromStudent();
			}
			else{
				questions.get(position-1).voidStudentAnswer();
				questions.get(position-1).getAnswerFromStudent();
			}
		}
		else{
			if(questions.get(position-1).isStudentAnswerEmpty() == true){
				questions.get(position-1).getAnswerFromStudent();
			}
			else{
				questions.get(position-1).voidStudentAnswer();
				questions.get(position-1).getAnswerFromStudent();
			}
		}

	}

	public boolean isEveryQuestionAnswered(ArrayList<Integer> skippedQuestions){
		boolean answered = true;

		for(int i = 0; i < questions.size(); i++){
			if(questions.get(i) instanceof MCMAQuestion){
				if(questions.get(i).isStudentAnswerEmpty() == true){
					skippedQuestions.add(i+1);
					System.out.println("You have some unanswered questions, answer them all to quit.\n Enter u or U to see which ones are not answered.");
					answered = false;
				}
			}
			else{
				if(questions.get(i).isStudentAnswerEmpty() == true){
					skippedQuestions.add(i+1);
					System.out.println("You have some unanswered questions, answer them all to quit.\n Enter u or U to see which ones are not answered.");
					answered = false;
				}

			}

		}
		return answered;
	}

	public double getValue() {//gets the total score
		double totalScore = 0.0;
		for(int i = 0; i < questions.size(); i++) {
			totalScore += questions.get(i).getValue();
		}

		return totalScore;
	}


	public void reportQuestionValues() {
		int totalScore = 0;
		System.out.println("Q#s |   Q Type     | Points ");
		for(int i = 0; i < questions.size(); i++) {
			//System.out.print("Question "+ (i+1) + ": ");
			if(questions.get(i) instanceof SAQuestion) {
				System.out.print((i+1) + ").   SAQuestion   " );
			}

			else if(questions.get(i) instanceof MCSAQuestion) {
				System.out.print((i+1) + ").   MCSAQuestion " );
			}

			else if(questions.get(i) instanceof MCMAQuestion) {
				System.out.print((i+1) + ").   MCMAQuestion " );
			}

			else if(questions.get(i) instanceof NumQuestion) {
				System.out.print((i+1) + ").   NumQuestion " );
			}

			System.out.println("| " + questions.get(i).getValue());
			totalScore += questions.get(i).getValue();
		}

		System.out.println("Total Score: " + totalScore);
	}


	public void save(PrintWriter writer) {
		int size = questions.size();
		int i = 0;
		//System.out.println(size);
		writer.write(title+"\r\n\r\n");

		while(i != size) {
			if(questions.get(i) instanceof SAQuestion) {
				writer.write("SAQuestion\r\n");
				((SAQuestion)questions.get(i)).save(writer);
				writer.write("\r\n");
			}

			else if (questions.get(i) instanceof MCSAQuestion) {
				writer.write("MCSAQuestion\r\n");
				((MCSAQuestion)questions.get(i)).save(writer);
				writer.write("\r\n");
			}

			else if(questions.get(i) instanceof MCMAQuestion) {
				writer.write("MCMAQuestion\r\n");
				((MCMAQuestion)questions.get(i)).save(writer);
				writer.write("\r\n");
			}

			else if(questions.get(i) instanceof NumQuestion) {
				writer.write("NumQuestion\r\n");
				((NumQuestion)questions.get(i)).save(writer);
				writer.write("\r\n");
			}

			i++;
		}

		writer.flush();

	}


	public void saveStudentAnswers(PrintWriter writer) {
		int size = questions.size();
		int i = 0;

		while(i != size) {

			if(questions.get(i) instanceof SAQuestion) {
				writer.write("SAAnswer\r\n");
				((SAQuestion)questions.get(i)).saveStudentAnswer(writer);
				writer.write("\r\n");
			}

			else if(questions.get(i) instanceof MCSAQuestion) {
				writer.write("MCSAAnswer\r\n");
				((MCSAQuestion)questions.get(i)).saveStudentAnswer(writer);
				writer.write("\r\n");
			}

			else if(questions.get(i) instanceof MCMAQuestion) {
				writer.write("MCMAAnswer\r\n");
				((MCMAQuestion)questions.get(i)).saveStudentAnswer(writer);
				writer.write("\r\n");
			}

			else if(questions.get(i) instanceof NumQuestion) {
				writer.write("NumAnswer\r\n");
				((NumQuestion)questions.get(i)).saveStudentAnswer(writer);
				writer.write("\r\n");
			}
			i++;
		}
		writer.flush();
	}


	public void restoreStudentAnswers(Scanner scan) {
		String nString;
		double maxValue;
		int i = 0;
		while(scan.hasNextLine()) {
			nString = scan.nextLine();
			if(nString.equals("")) {
				continue;
			}

			else if(nString.equals("SAAnswer") && (questions.get(i) instanceof SAQuestion)) {
				((SAQuestion)questions.get(i)).restoreStudentAnswers(scan);
				i++;
			}

			else if(nString.equals("MCSAAnswer") && (questions.get(i) instanceof MCSAQuestion)) {
				((MCSAQuestion)questions.get(i)).restoreStudentAnswers(scan);
				i++;
			}

			else if(nString.equals("MCMAAnswer") && (questions.get(i) instanceof MCMAQuestion)) {
				((MCMAQuestion)questions.get(i)).restoreStudentAnswers(scan);
				i++;
			}

			else if(nString.equals("NumAnswer") && (questions.get(i) instanceof NumQuestion)) {
				((NumQuestion)questions.get(i)).restoreStudentAnswers(scan);
				i++;
			}

		}
	}

	public int getNumOfQuestion(){
		return questions.size();
	}

	public String getQuestion(int position){
		return questions.get(position-1).getQuestion();
	}

}
