// Typing speed analysis methods
// JHC
// February 2016

import java.lang.System;

public class SpeedAnalyzer {
	String userInput = "";
	double typingSpeed = 0;
	double timeTaken = 0;

	// ctor
	public SpeedAnalyzer(String _userInput, double _timeTaken) {
		userInput = _userInput;
		timeTaken = _timeTaken;
	}
	
	// main speed analysis method
	public double Analyze() {
		typingSpeed = CalculateSpeed(CountWords(userInput), timeTaken);
		return typingSpeed;
	}

	// count how many words (where a word is defined as 5 characters) the user has entered
	private int CountWords(String userInput) {
		int numChars = userInput.length();
		int numWords = numChars/5;
		return numWords;
	}

	private double CalculateSpeed(int words, double timeTaken) {
		double speed = 0;
		speed = words/(timeTaken/60);
		return speed;
	}
}
