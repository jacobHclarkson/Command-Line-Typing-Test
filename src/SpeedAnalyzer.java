// Typing speed analysis methods
// JHC
// February 2016

import java.lang.System;

public class SpeedAnalyzer {
	String userInput = "";
	double grossTypingSpeed = 0;
	double netTypingSpeed = 0;
	double timeTaken = 0;
	int errors = 0;

	// ctor
	public SpeedAnalyzer(String _userInput, double _timeTaken, int _errors) {
		userInput = _userInput;
		timeTaken = _timeTaken;
		errors = _errors;
	}
	
	// main speed analysis method
	public void Analyze() {
		grossTypingSpeed = CalculateSpeed(CountWords(userInput), timeTaken);
		netTypingSpeed = grossTypingSpeed - (errors/(timeTaken/60));
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
