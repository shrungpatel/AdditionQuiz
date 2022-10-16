/**
 * @author Shrung K. Patel
 * Implementation of this class's methods caused a lot of errors so I did not use it because the project would not have been complete otherwise
 */
package application;
import java.util.*;
public abstract class Game {
	int currentScore, currentStreak, highestStreak;
	int easyTotal, easyRight, mediumTotal, mediumRight, hardTotal, hardRight, totalQuestions;
	String name, difficultyOfQuestion;
	double totalAccuracy, easyAccuracy, mediumAccuracy, hardAccuracy;
	public Game() {
		
	}
	public double calculateEasyAccuracy(boolean accurate) { 
		return (accurate? (++this.easyRight/++this.easyTotal) * 100: (this.easyRight/++this.easyTotal) * 100);
	}
	public double calculateMediumAccuracy(boolean accurate) { 
		return (accurate? (++this.mediumRight/++this.mediumTotal) * 100: (this.mediumRight/++this.mediumTotal) * 100);
	}
	public double calculateHardAccuracy(boolean accurate) { 
		return (accurate? (++this.hardRight/++this.hardTotal) * 100: (this.hardRight/++this.hardTotal) * 100);
	}
	public abstract void calculateAccuracyByType(String type) {
		
	}
	public void checkHighestStreak(int currentStreak) {
		this.highestStreak = Math.max(currentStreak, this.highestStreak);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public int getEasyRight() {
		return this.easyRight;
	}
	public int getMediumRight() {
		return this.mediumRight;
	}
	public int getHardRight() {
		return this.hardRight;
	}
	public int getEasyTotal() {
		return this.easyTotal;
	}
	public int getMediumTotal() {
		return this.mediumTotal;
	}
	public int getHardTotal() {
		return this.hardTotal;
	}
	public int getTotalQuestions() {
		return this.easyTotal + this.mediumTotal + this.hardTotal;
	}
	public double getTotalAccuracy() {
		return this.currentScore / this.totalQuestions * 100.00 / 100;
	}
	public double getEasyAccuracy() {
		return this.easyRight / this.easyTotal * 100.00/ 100;
	}
	public double getMediumAccuracy() {
		return this.mediumRight / this.mediumTotal * 100.00/ 100;
	}
	public double getHardAccuracy() {
		return this.hardRight / this.hardTotal * 100.00/ 100;
	}
}