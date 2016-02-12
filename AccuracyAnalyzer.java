// methods to analyze the accuracy of user input
// JHC
// February 2016

import java.util.ArrayList;

public class AccuracyAnalyzer {
	ArrayList<String> prompt;
	String promptString = "";
	String input = "";
	String transcribed ="";
	int [][] sMatrix;
	int corrections = 0;

	// ctor
	public AccuracyAnalyzer(ArrayList<String> _prompt, String _input, String _transcribed, int _corrections) {
		// convert array of prompt words into a single string
		for(int i=0 ; i<_prompt.size()-1 ; i++) {
			promptString += (_prompt.get(i) + " ");
		}
		promptString += _prompt.get(_prompt.size()-1);

		transcribed = _transcribed;
		input = _input;
		corrections = _corrections;

		// create string comparison matrix
		sMatrix = new int[Math.max(promptString.length(), transcribed.length())][Math.max(promptString.length(), transcribed.length())];
	}

	// main analysis method
	public double Analyze() {
		double C = (double)(Correct());
		System.out.println ("correct: " + C);
		double INF = (double)(IncorrectNotFixed());
		System.out.println("incorrect not fixed: " + INF);
		double IF = (double)(IncorrectFixed());
		System.out.println("incorrect fixed: " + IF);
		double totalErrorRate = ((INF + IF)/(C + INF + IF)) * 100;
		System.out.println("total error rate: " + totalErrorRate);
		double accuracy = 100 - totalErrorRate;
		return accuracy;
	}

	// return number of correct keystrokes
	// C = max(|presented|, |transcribed|) - MSD(presented, transcribed)
	private int Correct() {
		return (Math.max(promptString.length(), transcribed.length()) - MSD(sMatrix));
	}

	// return number of incorrect characters that were not fixed
	// INF = MSD(presented, transcibed)
	private int IncorrectNotFixed() {
		return MSD(sMatrix);
	}

	// return number of backspaces pressed
	private int Fixes() {
		return corrections;	
	}

	// return number of keystrokes used for fixes
	// chars in inStream that are not in transcribed
	private int IncorrectFixed() {
		int count = 0;
		// iterate through and check char for char, increment to keep aligned
		int j = 0;
		for(int i=0 ; i<transcribed.length()-1 ; i++) {
			if(input.charAt(j) == transcribed.charAt(i) && transcribed.charAt(i) != '<') {} else {
				count += 1;
				i = i-1;
				j += 1;
			}
			j += 1;
		}
		return count;
	}

	// returns the Minimum String Distance between two strings
	private int MSD(int[][] sMatrix) {
		for(int i=0 ; i<promptString.length() ; i++) {
			sMatrix[i][0] = i;
		} 
		for(int j=0 ; j<transcribed.length() ; j++) {
			sMatrix[0][j] = j;
		}
		for(int i=1 ; i<promptString.length() ; i++) {
			for(int j=1 ; j<transcribed.length() ; j++) {
				int x = sMatrix[i-1][j] + 1;
				int y = sMatrix[i][j-1] + 1;
				int z = sMatrix[i-1][j-1] + MSDhelper(promptString.charAt(i), transcribed.charAt(j));
				sMatrix[i][j] = Math.min(Math.min(x, y), Math.min(y, z));
			}
		}
		return sMatrix[promptString.length()-1][transcribed.length()-1];
	}
	private int MSDhelper(char a, char b) {
		if(a == b)
			return 0;
		else
			return 1;
	}
}
