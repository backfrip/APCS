import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void checkIntegerArray(Integer[] check, Integer[] base) {
	if (Arrays.equals(check, base))
	    System.out.println("Sort successful");
	else
	    System.out.println("Sort unsuccessful");
    }

    public static void main(String[] args) {
	int length = 50000;

	System.out.println("> Array length: " + length);

	Integer[] base = new Integer[length];
	Random randy = new Random(10);
	long t;

	// Array Generation
	System.out.println("> Generating Integer array...");

	for (int i = 0; i < length; i++) {
	    base[i] = new Integer(randy.nextInt(21));
	}

	//System.out.println(Arrays.toString(base));

	// Array Cloning
	System.out.println("> Cloning array...");

	Integer[] bubble = base.clone();
	Integer[] selection = base.clone();
	Integer[] insertion = base.clone();

	// Arrays.sort() Sort
	System.out.println("> Arrays.sort()-ing...");

	t = System.currentTimeMillis();
	Arrays.sort(base);
	System.out.println((System.currentTimeMillis() - t) / 1000.0);

	// System.out.println(Arrays.toString(base));

	// Bubble Sort
	System.out.println("> Bubble sorting...");

	t = System.currentTimeMillis();
	Sorts.bubble(bubble);
	System.out.println((System.currentTimeMillis() - t) / 1000.0);

	// System.out.println(Arrays.toString(bubble));

	checkIntegerArray(bubble, base);

	// Selection Sort
	System.out.println("> Selection sorting...");
	
	t = System.currentTimeMillis();
	Sorts.selection(selection);
	System.out.println((System.currentTimeMillis() - t) / 1000.0);

	// System.out.println(Arrays.toString(selection));

	checkIntegerArray(selection, base);

	// Insertion Sort
	System.out.println("> Insertion sorting...");
	
	t = System.currentTimeMillis();
	Sorts.insertion(insertion);
	System.out.println((System.currentTimeMillis() - t) / 1000.0);

	//System.out.println(Arrays.toString(insertion));

	checkIntegerArray(insertion, base);
    }
}