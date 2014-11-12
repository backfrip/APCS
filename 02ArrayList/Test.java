import java.util.ArrayList;

public class Test {
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

    }



    static void collapseDuplicates(ArrayList<Integer> L) {
	for (int i = 0; i < L.size()-1; i++) {
	    if ((int)L.get(i) == (int)L.get(i+1)) {
		L.remove(i+1);
		i--;
	    }
	}
    }


}
