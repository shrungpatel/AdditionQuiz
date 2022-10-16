/**
 * @author Shrung K. Patel
 */
package application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class Start extends Application {
	// Are on the outside so startGmae() can access them
	GridPane pane;
	TextField tfName;
	Button btnAddName;
	@Override
	public void start(Stage primaryStage) {
		// Adding buttons, textfields, and labels
		pane = new GridPane();
		pane.add(new Label("Welcome to the quiz game!"), 0, 0);
		pane.add(new  Label("First Name:"), 0, 1);
		tfName = new TextField();
		tfName.setEditable(true);
		pane.add(tfName, 1, 1);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		btnAddName = new Button("Add Name");
		pane.add(btnAddName, 1, 2);
		btnAddName.setOnAction(e -> startGame());
		
		pane.setHgap(5.5);
		pane.setVgap(10);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Math Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void startGame() {
		String userName = tfName.getText();
		btnAddName = new Button("Good luck " + userName); // Changes the button to wish the user luck
		pane.add(btnAddName, 1, 2);
		// Sets up the game so you can see the questions/answers
		for(int a = 3; a < 20; a += 2) {
			Label lblQuestion = new Label("");
			TextField tfAnswer = new TextField();
			pane.add(lblQuestion, 0, a);
			pane.add(tfAnswer, 1, a);
			Button btnCheckAnswer = new Button("Check Answer");
			pane.add(btnCheckAnswer, 1, a + 1);
			tfName.setEditable(false);
			int typeOfQues = (int) (Math.random() * 3);
			String quesDiff = (typeOfQues == 0)? "easy": (typeOfQues == 1)? "medium": "hard";

			String newQuestion = MathGame.makeQuestionText(quesDiff);
			
			lblQuestion = new Label(MathGame.extractQuestion(newQuestion));
			pane.add(lblQuestion, 0, a);
			btnCheckAnswer.setOnAction(e -> Question.checkCorrect(MathGame.correctAnswer(newQuestion), Integer.parseInt(tfAnswer.getText())));
		}
	}
}
/**
 * Let the user control how many questions they want to answer
 * Add the accuracy methods from MathGame/Game
 * Instead of printing out to the console, add a button/label that says correct/incorrect right below the question
 * Add exception handling if needed
*/