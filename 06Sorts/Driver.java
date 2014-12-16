import java.util.Arrays;

public class Driver {
    public static void main(String[]args) {
	String[]one = {"1", "2", "3", "4"};
	System.out.println(Arrays.toString(one));
	Sorts.bubble(one);
	System.out.println(Arrays.toString(one));
    }
}