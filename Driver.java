// Driver for typing tester
// JHC
// February 2016

public class Driver {
	public static void main(String[]args) {
		//AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer();
		Prompt prompt = new Prompt();

		prompt.Start();

		//System.out.println("backspaces:" + prompt.backSpaces);
		//for(int i=0 ; i<prompt.chosenWords.size() ; i++) {
	//		System.out.print(prompt.chosenWords.get(i) + " ");
	//	}	
	

		//System.out.println(prompt.inStream);


		AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer(prompt.chosenWords, prompt.inStream, prompt.finalUserInput, prompt.backSpaces);

		System.out.println("Accuracy: " + accAnalyzer.Analyze());
		SpeedAnalyzer sA = new SpeedAnalyzer(prompt.finalUserInput, prompt.timeTaken);
		System.out.println(sA.Analyze());
	}
}
