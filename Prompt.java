// methods involved in prompting user for input and capturing user input
// JHC
// February 2016

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// fancy library for grabbing key events
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

// dealing with console polution
import java.util.logging.Logger;
import java.util.logging.Level;

public class Prompt implements NativeKeyListener {
	String wordString = "";
	String[] wordList;
	String finalUserInput = "";
	double timeTaken = 0;
	int backSpaces = 0;

	// ctor
	public Prompt() {
		// squash native key console logging
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		logger.setUseParentHandlers(false);

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
		Random rand = new Random();
		for(int i=0 ; i<20 ; i++)
		{
			// randomly select some words from the word array
			int max = wordList.length;
			int min = 0;
			int index = rand.nextInt((max - min)) + min;
			chosenWords.add(wordList[index]);
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
		long startTime = System.nanoTime();
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.out.println("Problem with native hook.");
		}
		GlobalScreen.addNativeKeyListener(this);
		Scanner input = new Scanner(System.in);
		String capturedInput = input.nextLine();
		input.close();
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double timeElapsedSeconds = timeElapsed / 1000000000.0;
		timeTaken = timeElapsedSeconds;
		finalUserInput = capturedInput;
		System.out.println(backSpaces);
	}

	// methods to get keys pressed
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_ENTER) {
			try {	
				GlobalScreen.unregisterNativeHook();
			} catch(Exception error){}
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
			// count the backspaces
			backSpaces += 1;
		}

	}
	// have to overload these but don't need them to do anything
	public void nativeKeyTyped(NativeKeyEvent e) {}
	public void nativeKeyReleased(NativeKeyEvent e){}
}
