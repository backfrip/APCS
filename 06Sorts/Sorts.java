import java.util.Arrays;

public class Sorts {
    public static <T extends Comparable<T>> void bubble(T[] a) {
	int n = a.length;
	while (n > 0) {
	    for (int i = 0; i < n; i++) {
		
	    }
	}
    }

    public static <T extends Comparable<T>> void selection(T[] a) {
	T min;
	int swapdex;
	for (int index = 0; index < a.length; index++) {
	    min = a[index];
	    swapdex = index;
	    for (int i = index; i < a.length; i++) {
		if (a[i].compareTo(min) < 0) {
		    min = a[i];
		    swapdex = i;
		}
	    }
	    a[swapdex] = a[index];
	    a[index] = min;
	}
    }

    public static <T extends Comparable<T>> void insertion(T[] a) {
	T temp;
	int index;
	boolean exit;
	for (int i = 1; i < a.length; i++) {
	    if (a[i].compareTo(a[i - 1]) <= 0) {
		temp = a[i];
		exit = false;
		for (index = i - 1; !exit && index >= 0; index--) {
		    if (temp.compareTo(a[index]) >= 0) {
			index += 1;
			exit = true;
		    }
		}
		index += 1;
		for (int c = i; c > index; c--) {
		    a[c] = a[c - 1];
		}
		a[index] = temp;
	    }
	}
    }
}