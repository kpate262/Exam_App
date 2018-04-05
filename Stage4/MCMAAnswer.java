import java.util.*;
import java.io.*;

public class MCMAAnswer extends MCAnswer{
	
	public MCMAAnswer(String text, double creditIfSelected) {
		super(text, creditIfSelected);
	}
	
	public MCMAAnswer(Scanner scan) {
		super(scan);
		super.creditIfSelected = scan.nextDouble();
		scan.findInLine(".").charAt(0);
		super.text = scan.nextLine();
	}
}
