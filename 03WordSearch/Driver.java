public class Driver {
    public static void main(String[] args) {
	// int rows = args[0];
	// int cols = args[1];
	// long randomSeed = args[2];
	// int answers = args[3];
	
	WordGrid test = new WordGrid(5, 5);
	test.addWord("ONE", 0, 0, 1, -1);
	test.addWord("OREOS", 0, 0, 1, 0);
	test.addWord("SPEED", 0, 4, 0, -1);
	test.addWord("DEEPO", 4, 3, 0, 1);
	test.addWord("DDDDD", 4, 4, -1, 0);
	test.addWord("DEEPS", 4, 0, 1, 1);
	test.addWord("EEE", 2, 2, 1, 0);
	
	System.out.print(test);
    }
}
