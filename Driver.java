// Driver for typing tester
// JHC
// February 2016

public class Driver {
	public static void main(String[]args) {
		AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer();
		Prompt prompt = new Prompt();

		prompt.Start();
		SpeedAnalyzer sA = new SpeedAnalyzer(prompt.finalUserInput, prompt.timeTaken);
		System.out.println(sA.Analyze());
	}
}
