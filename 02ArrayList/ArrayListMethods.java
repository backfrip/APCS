import java.util.*;

public class ArrayListMethods {

    public static void collapseDuplicates(ArrayList<Integer> L) {
	for (int i = 0; i < L.size()-1; i++) {
	    if ((int)L.get(i) == (int)L.get(i+1)) {
		L.remove(i+1);
		i--;
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L) {
	Random randy = new Random();
	for (int i = L.size()-1; i >= 0; i--) {
	    L.add(L.remove(randy.nextInt(i+1)));
	}
    }

    public static void main(String[]args) {

	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(new Integer(3));
	L.add(new Integer(4));
	L.add(new Integer(4));
	L.add(new Integer(2));
	L.add(new Integer(2));
	L.add(new Integer(1));
	L.add(new Integer(2));

	collapseDuplicates(L);
	System.out.println(L);

	System.out.println();
	ArrayList<Integer> M = new ArrayList<Integer>();
	for (int i = 1; i < 21; i++) {
	    M.add(i);
	}
	System.out.println(M);
	System.out.println();

	randomize(M);
	System.out.println(M);

    }

}
