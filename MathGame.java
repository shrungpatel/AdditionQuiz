/**
 * @author Shrung K. Patel
 */
package application;
import java.io.*;
import java.util.*;
public class MathGame extends Game implements Question {
	@Override
	public void calculateAccuracyByType(String type) {
		if (type.equals("mul")) calculateMulAccuracy();
		else if (type.equals("div")) calculateDivAccuracy();
		else if (type.equals("add")) calculateAddAccuracy();
		else calculateSubAccuracy();
	}
	public static void calculateMulAccuracy() {
		accuracyByType[0] = totalCorrectByType[0] / totalByType[0] * 100.00 / 100;
	}
	public static double getMulAccuracy() {
		return accuracyByType[0];
	}
	public static void calculateAddAccuracy() {
		accuracyByType[1] = totalCorrectByType[1] / totalByType[1] * 100.00 / 100;

	}
	public static double getAddAccuracy() {
		return accuracyByType[1];
	}
	public static void calculateSubAccuracy() {
		accuracyByType[2] = totalCorrectByType[2] / totalByType[2] * 100.00 / 100;

	}
	public static double getSubAccuracy() {
		return accuracyByType[2];
	}
	public static void calculateDivAccuracy() {
		accuracyByType[3] = totalCorrectByType[3] / totalByType[3] * 100.00 / 100;
	}
	public static double getDivAccuracy() {
		return accuracyByType[3];
	}
	//@Override
	public static String makeQuestionText(String type) {
		// Removed this because it was easier to generate questions on the spot

		// Looks through the appropriate question bank
		// The 3 files are stored on my computer, how should I modify the file location so it can be ran on computers other than mine?
		
		/**
		if (type.equals("easy")) Scanner input = new Scanner(new File("C:\\Users\\krupa\\Documents\\Shrung\\12th grade\\Software Development Using Java\\Module 6\\TestClasses\\TestClasses\\src\\easyQuestions.txt"));
		
		else if(type.equals("medium")) Scanner input = new Scanner(new File("C:\\Users\\krupa\\Documents\\Shrung\\12th grade\\Software Development Using Java\\Module 6\\TestClasses\\TestClasses\\src\\mediumQuestions.txt"));
		else Scanner input = new Scanner(new File("C:\\Users\\krupa\\Documents\\Shrung\\12th grade\\Software Development Using Java\\Module 6\\TestClasses\\TestClasses\\src\\hardQuestions.txt"));
		int randomNumber = (int) (Math.random() * 1000);
		String line = "";
		for(int a = 0; a <= randomNumber; a++) {
			line = input.nextLine();
			System.out.println(line);
		}
		*/
		int a, b, num1, num2;
		if(type.equals("easy")) 
		{
			a = 10;
			b = 0;
		}
		else if(type.equals("medium")) {
			a = 15;
			b = 5;
		}
		else {
			a = 20;
			b = 10;
		}
		num1 = (int) (Math.random() * a) + b;
		num2 = (int) (Math.random() * a) + b;
		String line = num1 + " + " + num2 + " = " + (num1 + num2); 
		return line;
	}
	//@Override
	public static String extractQuestion(String questionText) {
		String[] parts = questionText.split("=");
		String question = parts[0] + " = ?";
		return question;
	}
	//@Override
	public static int correctAnswer(String fullQuestion) {
		String[] parts = fullQuestion.split("=");
		parts[1] = parts[1].substring(1, parts[1].length());
		return Integer.parseInt(parts[1]);
		
	}
	// Used to test the class without JavaFX
	/**
	public static void main(String[] args) {
		int[] totalCorrectByType, totalByType;
		double[] accuracyByType;
		int correctAnswer, userAnswer;
		String quesDiff; // Difficulty of question
		int typeOfQues;
		MathGame currentGame = new MathGame();
		Scanner userInput = new Scanner(System.in);
		for(int a = 0; a < 20; a++) { // 20 questions in a game
			typeOfQues = (int)(Math.random() * 3);
			quesDiff = (typeOfQues == 0)? "easy": (typeOfQues == 1)? "medium": "hard";
			String fullQuestion = currentGame.makeQuestionText(quesDiff);
			String justQuestion = currentGame.extractQuestion(fullQuestion);
			correctAnswer = currentGame.correctAnswer(fullQuestion);
			System.out.println(justQuestion);
			System.out.println("What is the correct answer?");
			userAnswer = Integer.parseInt(userInput.next());
			boolean accurate = currentGame.checkCorrect(correctAnswer, userAnswer);
			if(typeOfQues == 0) currentGame.calculateEasyAccuracy(accurate);
			else if (typeOfQues == 1) currentGame.calculateMediumAccuracy(accurate);
			else currentGame.calculateHardAccuracy(accurate);
			System.out.println("Easy accuracy: " + currentGame.getEasyAccuracy() + ", Medium accuracy: " + currentGame.getMediumAccuracy() + ", Hard accuracy: " + currentGame.getHardAccuracy());
		}
		System.out.println("Total Accuracy: " + currentGame.getTotalAccuracy());
	}
	*/
}