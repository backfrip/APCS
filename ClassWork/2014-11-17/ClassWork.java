public class ClassWork {
    
    static boolean contains(int value, int[]a) {
	for ( int n : a ) {
	    if (n == value)
		return true;
	}
	return false;
    }

    static boolean contains(int value, int[][]a) {
	for ( int[]n : a) {
	    if (contains(value, n))
		return true;
	}
	return false;
    }

    static String stringify(int[]a) {
	String ret = "[ ";
	for ( int n : a ) {
	    ret += n + " ";
	}
	return ret + "]";
    }

    static String stringify(int[][]a) {
	String ret = "[ ";
	for ( int[]n : a ) {
	    ret += stringify(n) + " ";
	}
	return ret + "]";
    }
    
    public static void main(String[]args) {
	
	int[]a = {1, 2, 3};
	System.out.println(stringify(a) + "\n" + contains(3, a));
	a[2] = 2;
	System.out.println(stringify(a) + "\n" + contains(3, a));

	int[][]b = { {1, 2, 3}, {1, 2, 4} };
	System.out.println(stringify(b) + "\n" + contains(3, b));
	b[0][2] = 2;
	System.out.println(stringify(b) + "\n" + contains(3, b));

    }

}
