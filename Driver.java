// Driver for typing tester
// JHC
// February 2016

public class Driver {
	public static void main(String[]args) {
		AccuracyAnalyzer accAnalyzer = new AccuracyAnalyzer();
		SpeedAnalyzer speedAnalyzer = new SpeedAnalyzer("robotrobotrobot", 60);
		Prompt prompt = new Prompt();

		accAnalyzer.Analyze();
		System.out.println(speedAnalyzer.Analyze());
		prompt.Start();
	}
}
