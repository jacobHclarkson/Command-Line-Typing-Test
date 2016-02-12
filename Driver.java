// Driver for typing tester
// JHC
// February 2016

import java.text.DecimalFormat;

public class Driver {
	public static void main(String[]args) {
		// make a new prompt for the user and get input
		Prompt prompt = new Prompt();
		prompt.Start();

		// create accuracy and speed analyzers based on user input and the prompt text
		AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer(prompt.chosenWords, prompt.inStream, prompt.finalUserInput, prompt.backSpaces);
		accAnalyzer.Analyze();
		SpeedAnalyzer sA = new SpeedAnalyzer(prompt.finalUserInput, prompt.timeTaken, (int)accAnalyzer.INF);
		sA.Analyze();

		// print statistics
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		System.out.println();
		System.out.println("STATISTICS");
		System.out.println("----------");
		System.out.println("Correct Keystrokes: " + (int)accAnalyzer.C);
		System.out.println("Corrected Errors:   " + (int)accAnalyzer.IF);
		System.out.println("Uncorrected Errors: " + (int)accAnalyzer.INF);
		System.out.println();
		System.out.println("Overall Accuracy:   " + df.format(accAnalyzer.accuracy) + " %");
		System.out.println();
		System.out.println("Gross WPM:         " + df.format(sA.grossTypingSpeed) + " WPM");
		System.out.println("Net WPM:           " + df.format(sA.netTypingSpeed) + "WPM");
	}
}
