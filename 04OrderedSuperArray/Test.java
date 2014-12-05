import java.util.Random;
import java.util.Arrays;

public class Test {
    //because it takes too long to write :P
    public static void sop(Object o) {
	System.out.println(o);
    }
    public static void main(String[] args) {
	/*
	  OrderedSuperArray<String> osa = new OrderedSuperArray<String>();
	  osa.add("hello");
	  sop(osa);
	  osa.add("jello");
	  sop(osa);
	  osa.add("interrogate");
	  sop(osa);
	  osa.add("abacus");
	  sop(osa);
	  osa.add("cancer");
	  sop(osa);
	
	  OrderedSuperArray<Integer> osai = new OrderedSuperArray<Integer>();
	  osai.add(new Integer(3));
	  osai.add(new Integer(7));
	  osai.add(new Integer(1));
	  osai.add(new Integer(3));
	  sop(osai);

	  //osai.add("ERROR");
	  */
	/*
	SuperArray<String> sa = new SuperArray<String>();
	sa.add("alpha");
	sa.add("charlie");
	sa.add("delta");
	sa.add("bravo");
	sa.add("echo");
	sa.add("foxtrot");
	sop(sa);
	sa.insertionSort();
	sop(sa);
	*/
	
	int length = 100000;
	sop(">> Sorting lists of length: " + length);
	Random randy = new Random();
	SuperArray<Integer> sup = new SuperArray<Integer>();
	Integer[]ia = new Integer[length];
	Integer t;
	sop(">> Constructing lists...");
	for (int i = 0; i < length; i++) {
	    t = new Integer(randy.nextInt(51));
	    ia[i] = t;
	    sup.add(t);
	}
	//sop(sup);
	//sop(Arrays.toString(ia));
	sop(">> Sorting array...");
	Arrays.sort(ia);
	sop(">> Sorting SuperArray...");
	sup.insertionSort();
	//sop(Arrays.toString(ia));
	//sop(sup);
	sop(">> Result of .equals() test:");
	sop(Arrays.toString(ia).equals(sup.toString()));
	//sop(Arrays.toString(ia));
	//sop("SuperArray toString()ing...");
	//sop(sup.toString());
    }
    
}