
stage3: ExamTester.class
	java ExamTester

stage4: ExamTaker.class
	java ExamTaker

ExamTaker.class: ExamTaker.java
	javac -g ExamTaker.java

ExamTester.class: ExamTester.java
	javac -g ExamTester.java

Exam.class: Exam.java
	javac -g Exam.java

Question.class: Question.java
	javac -g Question.java

Answer.class: Answer.java
	javac -g Answer.java

ScannerFactory.class: ScannerFactory.java
	javac -g ScannerFactory.java

MCQuestion.class: MCQuestion.java
	javac -g MCQuestion.java

MCSAQuestion.class: MCSAQuestion.java
	javac -g MCSAQuestion.java

MCMAQuestion.class: MCMAQuestion.java
	javac -g MCMAQuestion.java

MCAnswer.class: MCAnswer.java
	javac -g MCAnswer.java

MCSAAnswer.class: MCSAAnswer.java
	javac -g MCSAAnswer.java

MCMAAnswer.class: MCMAAnswer.java
	javac -g MCMAAnswer.java

NumQuestion.class: NumQuestion.java
	javac -g NumQuestion.java

NumAnswer.class: NumAnswer.java
	javac -g NumAnswer.java

SAQuestion.class: SAQuestion.java
	javac -g SAQuestion.java

SAAnswer.class: SAAnswer.java
	javac -g SAAnswer.java 

clean:
		$(RM) *.class
		rm Answer.txt
