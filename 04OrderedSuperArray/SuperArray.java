public class SuperArray<T extends Comparable<T>> {
    private Object[] superray;
    private int size = 0;

    public SuperArray() {
	superray = new Object[10];
    }

    public SuperArray(int cap) {
	superray = new Object[cap];
    }

    // adjusted to look like Arrays.toString()'s output
    public String toString() {
	String ret = "[";
	for (int i = 0; i < size - 1; i++) {
	    ret += superray[i] + ", ";
	}
	return ret + superray[size - 1] + "]";
    }

    public void add(T e) {
	if (size == superray.length)
	    resize(size * 2);
	superray[size] = e;
	size += 1;
    }

    public void add(int index, T e) {
	if (inRange(index)) {
	    if (size == superray.length)
		resize(size * 2);
	    for (int i = size; i > index; i--) {
		superray[i] = superray[i - 1];
	    }
	    set(index, e);
	    size += 1;
	} else {
	    throw new IndexOutOfBoundsException("invalid add index");
	}
    }

    public T remove(int index) {
	if (inRange(index)) {
	    // Types already checked (sorta)
	    @SuppressWarnings("unchecked")
	    T ret = (T) superray[index];
	    for (int i = index; i < superray.length - 1; i++) {
		superray[i] = superray[i + 1];
	    }
	    superray[size - 1] = null;
	    size -= 1;
	    if (size <= superray.length / 4)
		resize(size);
	    return ret;
	} else {
	    throw new IndexOutOfBoundsException("invalid remove index");
	}
    }

    public int size() {
	return size;
    }

    public void resize(int newCapacity) {
	Object[] temp = new Object[newCapacity];
	for (int i = 0; i < temp.length && i < superray.length; i++) {
	    temp[i] = superray[i];
	}
	superray = temp;
	if (newCapacity < size)
	    size = newCapacity;
    }

    public void clear() {
	for (int i = 0; i < superray.length; i++) {
	    superray[i] = null;
	}
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
	if (inRange(index))
	    return (T) superray[index];
	throw new IndexOutOfBoundsException("invalid get index");
    }

    public T set(int index, T e) {
	if (inRange(index)) {
	    superray[index] = e;
	    return e;
	} else {
	    throw new IndexOutOfBoundsException("invalid set index");
	}
    }

    private boolean inRange(int index) {
	return !(index < 0 || index >= size);
    }

    @SuppressWarnings("unchecked")
    public void insertionSort() {
	if (superray.length > 1) {
	    T temp;
	    int index;
	    boolean exit;
	    for (int i = 1; i < size; i++) {
		if (((T) superray[i]).compareTo(((T) superray[i - 1])) <= 0) {
		    temp = (T) superray[i];
		    exit = false;
		    for (index = i - 1; !exit && index >= 0; index--) {
			if (temp.compareTo(((T) superray[index])) >= 0) {
			    index += 1;
			    exit = true;
			}
		    }
		    index += 1;
		    for (int c = i; c > index; c--) {
			superray[c] = superray[c - 1];
		    }
		    superray[index] = temp;
		}
	    }
	}
    }

    @SuppressWarnings("unchecked")
    public void selectionSort() {
	if (superray.length > 1) {
	    T min;
	    int swapdex;
	    for (int index = 0; index < size; index++) {
		min = (T) superray[index];
		swapdex = index;
		for (int i = index; i < size; i++) {
		    if (((T) superray[i]).compareTo(min) < 0) {
			min = (T) superray[i];
			swapdex = i;
		    }
		}
		superray[swapdex] = superray[index];
		superray[index] = min;
	    }
	}
    }
}
