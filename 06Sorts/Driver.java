import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void main(String[]args) {
	int length = 10;
	Integer[]base = new Integer[length];
	Random randy = new Random();
	
	for (int i = 0; i < length; i++) {
	    base[i] = new Integer(randy.nextInt(21));
	}
	
	Integer[]bubble = base.clone();

	System.out.println(Arrays.toString(bubble));
	Sorts.bubble(bubble);
	System.out.println(Arrays.toString(bubble));
    }
}