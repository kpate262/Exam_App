import java.util.*;
import java.io.*;

public class ExamBuilder{

  public void printChoices(){
    System.out.println("\n****ATTENTION**** \nYou can either enter L or l to load an Exam or enter a through d to start creating questions.");
    System.out.println("**However, you can load an Exam and then add questions with options a through d**");
    System.out.println("Input a or A to build MCSAQuestion question");
    System.out.println("Input b or B to build MCMAQuestion question");
    System.out.println("Input c or C to build SAQuestion question");
    System.out.println("Input d or D to build NumQuestion question");
  }

  public static void main(String[] args) throws FileNotFoundException{
    ExamBuilder build = new ExamBuilder();
    build.printChoices();

    File file = null;
    Scanner scanInput = new Scanner(System.in);
    System.out.print("Enter your choice: ");
    char input = scanInput.nextLine().charAt(0);
    Exam newExam = new Exam();


    while(input != 'q' || input != 'Q'){
      if(input == 'l' || input == 'L'){
        file = new File(scanInput.nextLine());

      }

      input = scanInput.nextLine().charAt(0);
      if(input == 'q' || input == 'Q'){
        break;
      }
    }

  }//end of main

}
