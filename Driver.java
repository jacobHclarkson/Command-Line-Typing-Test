// Driver for typing tester
// JHC
// February 2016

public class Driver {
	public static void main(String[]args) {
		AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer();
		SpeedAnalyzer speedAnalyzer = new SpeedAnalyzer();
		Prompt prompt = new Prompt();

		accAnalyzer.Analyze();
		speedAnalyzer.Analyze();
		prompt.Start();
	}
}
