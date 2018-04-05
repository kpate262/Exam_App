import java.util.*;
import java.io.*;

public class ExamTester {


	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("\n\nAuthor: Kisan Patel\nNet Id: kpate262\n");

		System.out.println("Do you want to use your own Files or use the Files provided. Type [y]es or [n]o to use the provided?");

	  Scanner reader = new Scanner(System.in);
		char fReader = reader.findInLine(".").charAt(0);
		reader = null;

		reader = new Scanner(System.in);
		File file;

		if(fReader == 'y' || fReader == 'Y'){
			System.out.println("Enter file path if in diff folder or Filename if in same folder to read the Exam File");
			file = new File(reader.nextLine());
		}
		else{
			file = new File("exfile.txt");
		}
		Scanner scan = new Scanner(file);
		String newStrin;

		Exam ex1 = new Exam(scan);

		ex1.print();
		ex1.reorderQuestions();
		ex1.reorderMCAnswers(-1);
		System.out.println(">>>>>>>>>>>Exam Reordered<<<<<<<<<<<");
		ex1.print();

		PrintWriter writer;

		if(fReader == 'y' || fReader == 'Y'){
			System.out.println("Enter file path if in diff folder or Filename if in same folder to Write the Exam File");
			writer = new PrintWriter(new File(reader.nextLine()));
		}
		else{
			writer = new PrintWriter(new File("reorderedfile.txt"));
		}
		ex1.save(writer);
		writer.close();

		for(int i = 0; i < 3; i++) {
			System.out.print("\nNow Answer for #"+ (i+1) + ": ");
			ex1.getAnswerFromStudent(i+1);
			System.out.println("");
		}

		PrintWriter writer1;

		if(fReader == 'y' || fReader == 'Y'){
			System.out.println("Enter file path if in diff folder or Filename if in same folder to Write the Answers File");
			writer1 = new PrintWriter(new File(reader.nextLine()));
		}
		else{
			writer1 = new PrintWriter(new File("answers.txt"));
		}


		ex1.saveStudentAnswers(writer1);
		writer1.close();
		ex1 = null;
		scan.close();


		Scanner scan1;
		if(fReader == 'y' || fReader == 'y'){
			System.out.println("Enter file path if in diff folder or Filename if in same folder to read the Exam File");
			scan1 = new Scanner(new File(reader.nextLine()));
		}

		else{
			scan1 = new Scanner(new File("reorderedfile.txt"));
		}

		ex1 = new Exam(scan1);

		Scanner scanAnswers;
		if(fReader == 'y' || fReader == 'Y'){
			System.out.println("Enter file path if in diff folder or Filename if in same folder to read the Answers File");
			scanAnswers = new Scanner(new File(reader.nextLine()));
		}

		else{
			scanAnswers = new Scanner(new File("answers.txt"));
		}

		ex1.restoreStudentAnswers(scanAnswers);

		ex1.reportQuestionValues();


		return;
	}

}
