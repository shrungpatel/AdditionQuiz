/**
 * @author Shrung K. Patel
 */
package application;
import java.io.*;
public interface Question {
	// Commented these out because Start required static methods and abstract methods cannot be static
	
	//public static abstract String makeQuestionText(String type) {
		
	//}
	//public static abstract String extractQuestion(String questionText) {
		
	//}
	//public abstract int correctAnswer(String fullQuestion) {
		
	//}
	public static void checkCorrect(int correctAnswer, int userAnswer) {
		if (correctAnswer == userAnswer) System.out.println("Correct!");
		else System.out.println("Incorrect, the correct answer is " + correctAnswer);
	}
}
