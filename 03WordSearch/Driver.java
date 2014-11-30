import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
	// int rows = args[0];
	// int cols = args[1];
	// long randomSeed = args[2];
	// int answers = args[3];
	int rows = 0;
	int cols = 0;
	long randomSeed = 0;
	int answers = 0;
	boolean ans = true;

	try {
	    rows = Integer.parseInt(args[0]);
	    cols = Integer.parseInt(args[1]);
	    if (args.length > 2)
		randomSeed = Long.parseLong(args[2]);
	    if (args.length > 3)
		answers = Integer.parseInt(args[3]);
	} catch (Exception e) {
	    System.out.println("Proper syntax:");
	    System.out.println("java Driver rows cols [randomSeed [answers]]");
	    System.exit(0);
	}

	WordGrid w = new WordGrid(rows, cols);
	if (args.length > 2)
	    w.setSeed(randomSeed);
	if (args.length > 3)
	    if (answers == 1)
		ans = false;
	
	try {
	    w.loadWordsFromFile("words.txt", ans);
	} catch (FileNotFoundException e) {
	    System.err.println("\"words.txt\" could not be found in the Driver's directory");
	    System.exit(0);
	}
	
	System.out.println("Find these words:\n" + w.wordsInPuzzle());
	System.out.println(w);
    }
}
