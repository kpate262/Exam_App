import java.util.*;
import java.io.*;

public class ExamTaker{
  private String studentName;
  private int studentID;

  public void controls(){
    System.out.println("\n\nC or c: Prints all the controls.");
    System.out.println("Q or q: to quit");
    System.out.println("P or p: Prints the Exam");
    System.out.println("U or u: Prints unanswered question numbers\n\n");
  }

  public void getStudentInfo(){
    System.out.print("Enter your Name: ");
    studentName = ScannerFactory.getKeyboardScanner().nextLine();
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println("\nATTENTION: \n Answering answered questions will cause older answers to get deleted.\n");

    ExamTaker examTaker = new ExamTaker();
    examTaker.controls();
    examTaker.getStudentInfo();

    Scanner readInputFromUser = ScannerFactory.getKeyboardScanner();
    System.out.print("Enter file name: ");
    String fileName = readInputFromUser.nextLine();

    File file = new File(fileName);
    Scanner scan = new Scanner(file);

    char input = 'x';
    Exam newExam = new Exam(scan);
    newExam.print();

    //int i = 0;
    int size = 0;
    ArrayList<Integer> skippedQuestions = new ArrayList<Integer>();
  //  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
  //  System.out.println(timeStamp);
    PrintWriter writer = new PrintWriter(new File("Answer.txt"));
    writer.write(examTaker.studentName + "\r\n" + fileName + "\r\n\r\n");
    writer.flush();

    Scanner scanQNum = new Scanner(System.in);
    boolean answered;

    while(input != 'q' || input != 'Q'){
      System.out.println("Choose a question to answer (Enter question Number): ");
      newExam.getAnswerFromStudent(Integer.parseInt(scanQNum.nextLine()));

      System.out.println("Press q or Q to quit or any letter to Continue.");

      input = scanQNum.nextLine().charAt(0);

      if(input == 'p' || input == 'P'){
        newExam.print();
      }
      else if(input == 'c' || input == 'C'){
        examTaker.controls();
      }
      else if(input == 'q' || input == 'Q'){
        answered = newExam.isEveryQuestionAnswered(skippedQuestions);
        if(answered == false){
          char put = scanQNum.nextLine().charAt(0);
          if(put == 'u' || put == 'U'){
            System.out.print("\n***unanswered Questions: ");
            for(int k = 0; k < skippedQuestions.size(); k++){
              System.out.print(skippedQuestions.get(k) + " ");
            }
            System.out.println("***\n");
            for(int k = skippedQuestions.size()-1; k >= 0; k--){
              skippedQuestions.remove(k);
            }

          }
          continue;
        }
        else{
          break;
        }
      }

    }

    newExam.saveStudentAnswers(writer);
    writer.close();
  }
}
