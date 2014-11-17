public class ClassWork {
    
    static boolean contains(int value, int[]a) {
	for ( int n : a ) {
	    if (n == value)
		return true;
	}
	return false;
    }

    
    

    public static void main(String[]args) {
	
	int[]a = {1, 2, 3};
	System.out.println(contains(3, a));
	a[2] = 2;
	System.out.println(contains(3, a));

    }

}