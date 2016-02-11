// methods involved in prompting user for input and capturing user input
// JHC
// February 2016

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Prompt {
	String wordString = "";
	String[] wordList;

	// ctor
	public Prompt() {
		// read string of words from file
		try {
			BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
			wordString = br.readLine();
			br.close();
		} catch (IOException e) {
			System.out.println("Error retrieving word list from file.");
		}
		
		// store each word in array
		wordList = wordString.split(" ");
	}
	
	// main prompt method
	public void Start() {
		DisplayWords(ChooseWords());
		CaptureUserInput();
	}

	private ArrayList<String> ChooseWords() {
		ArrayList<String> chosenWords = new ArrayList<String>();
		for(int i=0 ; i<10 ; i++)
		{
			// randomly select some words from the word array
			Random rand = new Random();
			int max = wordList.length;
			int min = 0;
			int index = rand.nextInt((max - min) + 1) + min;
			chosenWords.add(wordList[i]);
		}
		return chosenWords;
	}
	
	private void DisplayWords(ArrayList<String> chosenWords) {
		for(int i=0 ; i<chosenWords.size() ; i++) {
			System.out.print(chosenWords.get(i) + " ");
		}
		System.out.println();
	}

	private void CaptureUserInput() {
	
	}
}
