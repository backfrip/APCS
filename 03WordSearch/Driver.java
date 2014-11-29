import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
	// int rows = args[0];
	// int cols = args[1];
	// long randomSeed = args[2];
	// int answers = args[3];
	
	WordGrid test = new WordGrid(40, 40);
	test.loadWordsFromFile("words.txt", false);
	
	System.out.println(test);
	System.out.println(test.wordsInPuzzle());
    }
}
