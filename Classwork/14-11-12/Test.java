import java.util.ArrayList;

public class Test {
    public static void main(String[]args) {

	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(new Integer(2));
	collapseDuplicates(L);

    }

    static void collapseDuplicates(ArrayList<Integer> L) {
	int a, b;
	for (int i = 0; i < L.size()-1; i++) {
	    a = L.get(i);
	    b = L.get(i+1);
	    if (a == b) {
		L.remove(i+1);
		i--;
	    }
	}
    }

}