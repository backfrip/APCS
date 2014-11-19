public class Classwork {
    
    public static void rect(int height, int width) {
	int i;
	while (height > 0) {
	    i = width;
	    while (i > 0) {
		System.out.print("*");
		i--;
	    }
	    System.out.println();
	    height--;
	}
    }

    public static void tri(int size) {
	int y = 1;
	int i;
	while (y <= size) {
	    i = 0;
	    while (i < y) {
		System.out.print("*");
		i++;
	    }
	    System.out.println();
	    y++;
	    
	}
    }

    public static void triBack(int size) {
	int i = 1;
	while (i <= size){
	    int y = size-i;
	    while (y > 0){
		System.out.print(" ");
		y--;
	    }
	    y = i;
	    while (y > 0){
		System.out.print("*");
		y--;
	    }
	    System.out.println();
	    i++;
	}
		      
    }
    
    public static void main(String[]args) {
	triBack(3);
	/* System.out.println("rect(3,2)");
	rect(3,2);
	System.out.println("rect(1,3)");
	rect(1,3);
	System.out.println("rect(5,20)");
	rect(5,20); */

    }
}