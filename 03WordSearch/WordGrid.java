import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid {
    private char[][] data;
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> added = new ArrayList<String>();
    private Random rand = new Random();

    /**
     * Initialize the grid to the size specified.
     *
     * @param rows
     *            the starting height of the WordGrid
     * @param cols
     *            the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols) {
	data = new char[rows][cols];
	clear();
    }

    /** Sets all values in the WordGrid to periods '.' */
    private void clear() {
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[0].length; j++) {
		data[i][j] = '.';
	    }
	}
    }

    /**
     * The proper formatting for a WordGrid is created in the toString.
     *
     * @return a String with each character separated by spaces, and each row
     *         separated by newlines.
     */
    @Override
    public String toString() {
	String ret = "";
	for (char[] dat : data) {
	    for (char da : dat) {
		ret += da + " ";
	    }
	    ret += '\n';
	}
	return ret;
    }

    /**
     * Reads random words from file <filename> and adds them to the WordGrid.
     * 
     * @param fileName
     *            the name of the file to read words from
     * @param fillRandomLetters
     *            if true, replaces any pluses with random letters after the
     *            words have been added
     */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters)
	    throws FileNotFoundException {
	Scanner in = new Scanner(new File(fileName));
	words.clear();
	while (in.hasNext()) {
	    words.add(in.nextLine());
	}
	in.close();
	addManyWordsToList(words);
	if (fillRandomLetters) {
	    for (int i = 0; i < data.length; i++) {
		for (int j = 0; j < data[0].length; j++) {
		    if (data[i][j] == '.')
			data[i][j] = (char)('a' + rand.nextInt(26));
		}
	    }
	}
    }

    /**
     * Attempts to add an ArrayList of words to the WordGrid.
     * 
     * @param allWords
     *            the ArrayList of words to be added
     */
    private void addManyWordsToList(ArrayList<String> allWords) {
	int tries = 100;
	boolean r;
	added.clear();
	for (String word : allWords) {
	    r = true;
	    for (int i = tries; i >= 0 && r; i--) {
		if (addWord(word.toLowerCase(), rand.nextInt(data.length),
			rand.nextInt(data[0].length), rand.nextInt(3) - 1,
			rand.nextInt(3) - 1)) {
		    r = false;
		    added.add(word);
		}
	    }
	}
    }

    /**
     * Returns a formatted list of words added to the WordGrid.
     * 
     * @return a formatted list of words
     */
    public String wordsInPuzzle() {
	return added.toString();
    }

    /**
     * Changes the seed of the WordGrid's Random object
     */
    public void setSeed(long seed) {
	// Nothing to C here yet
    }

    /**
     * Attempts to add a given word to the specified position of the WordGrid.
     * 
     * @param word
     *            the word to be added to the WordGrid
     * @param row
     *            the vertical start location
     * @param col
     *            the horizontal start location
     * @param xdir
     *            the direction in which to increment horizontally (-1, 0, or 1)
     * @param ydir
     *            the direction in which to increment vertically (-1, 0, or 1)
     */
    public boolean addWord(String word, int row, int col, int xdir, int ydir) {
	if (!((xdir != 0 || ydir != 0) && xdir <= 1 && xdir >= -1 && ydir <= 1 && ydir >= -1)) {
	    return false;
	}
	if (!(col + (word.length() * xdir) <= data[0].length
		&& col + 1 + (word.length() * xdir) >= 0
		&& row - (word.length() * ydir) <= data.length && row + 1
		- (word.length() * ydir) >= 0)) {
	    return false;
	}
	for (int i = 0; i < word.length(); i++) {
	    if (data[row - (i * ydir)][col + (i * xdir)] != word.charAt(i)
		    && data[row - (i * ydir)][col + (i * xdir)] != '.') {
		return false;
	    }
	}
	for (int i = 0; i < word.length(); i++) {
	    data[row - (i * ydir)][col + (i * xdir)] = word.charAt(i);
	}
	return true;
    }

    /**
     * Attempts to add a given word to the specified position of the WordGrid
     * horizontally. The word is added from left to right, must fit on the
     * WordGrid, and must have a corresponding letter to match any letters that
     * it overlaps.
     *
     * @param word
     *            any text to be added to the word grid
     * @param row
     *            the vertical location of where you want the word to start
     * @param col
     *            the horizontal location of where you want the word to start
     * @return true when the word is added successfully; false when the word
     *         doesn't fit or there are overlapping letters that do not match
     * @deprecated replaced by addWord()
     */
    @Deprecated
    public boolean addWordHorizontal(String word, int row, int col) {
	if (data[row].length - col >= word.length()) {
	    for (int c = 0; c < word.length(); c++) {
		if (data[row][c + col] != '.'
			&& data[row][c + col] != word.charAt(c)) {
		    return false;
		}
	    }
	    for (int c = 0; c < word.length(); c++) {
		data[row][c + col] = word.charAt(c);
	    }
	    return true;
	}
	return false;
    }

    /**
     * Attempts to add a given word to the specified position of the WordGrid
     * vertically. The word is added from top to bottom, must fit on the
     * WordGrid, and must have a corresponding letter to match any letters that
     * it overlaps.
     *
     * @param word
     *            any text to be added to the word grid
     * @param row
     *            the vertical location of where you want the word to start
     * @param col
     *            the horizontal location of where you want the word to start
     * @return true when the word is added successfully; false when the word
     *         doesn't fit or there are overlapping letters that do not match
     * @deprecated replaced by addWord()
     */
    @Deprecated
    public boolean addWordVertical(String word, int row, int col) {
	if (data.length - row >= word.length()) {
	    for (int r = 0; r < word.length(); r++) {
		if (data[row + r][col] != '.'
			&& data[row + r][col] != word.charAt(r)) {
		    return false;
		}
	    }
	    for (int r = 0; r < word.length(); r++) {
		data[row + r][col] = word.charAt(r);
	    }
	    return true;
	}
	return false;
    }

    /**
     * Attempts to add a given word to the specified position of the WordGrid
     * diagonally. The word is added from top left to bottom right, must fit on
     * the WordGrid, and must have a corresponding letter to match any letters
     * that it overlaps.
     *
     * @param word
     *            any text to be added to the word grid
     * @param row
     *            the vertical location of where you want the word to start
     * @param col
     *            the horizontal location of where you want the word to start
     * @return true when the word is added successfully; false when the word
     *         doesn't fit or there are overlapping letters that do not match
     * @deprecated replaced by addWord()
     */
    @Deprecated
    public boolean addWordDiagonal(String word, int row, int col) {
	if (data.length - row >= word.length()
		&& data[row].length - col >= word.length()) {
	    for (int y = 0; y < word.length(); y++) {
		if (data[row + y][col + y] != '.'
			&& data[row + y][col + y] != word.charAt(y)) {
		    return false;
		}
	    }
	    for (int y = 0; y < word.length(); y++) {
		data[row + y][col + y] = word.charAt(y);
	    }
	    return true;
	}
	return false;
    }

}
