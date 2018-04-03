import java.io.*;
import java.util.Scanner;

public abstract class Answer {

	protected Answer() {//constructor taking string

	}//'s/([A-Z-]*)(314-[0-9^-]*)([^ ]*)([[:alpha:].()^ ]*)/[ ]\1\3\4 :\2/p' data.txt
	
	public Answer(Scanner scan) {
		
	}

	abstract public void print();// prints itself if its selected or unselected
	

	abstract public double getCredit(Answer rightAnswer);
	
	abstract public void save(PrintWriter writer);
}
