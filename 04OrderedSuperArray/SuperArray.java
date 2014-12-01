public class SuperArray {
	private String[]superray;
	private int size = 0;

	
	public SuperArray() {
		superray = new String[10];
	}
	
	public SuperArray(int cap) {
		superray = new String[cap];
	}
	
	
	public String toString() {
		String ret = "[ ";
		for (int i = 0; i < size; i++) {
			ret += superray[i] + " ";
		}
		return ret + "]";
	}
	
	
	public void add(String e) {
		if (size == superray.length)
			resize(size*2);
		superray[size] = e;
		size += 1;
	}
	
	public void add(int index, String e) {
		if (inRange(index)) {
			if (size == superray.length)
				resize(size*2);
			for (int i = index+1; i < superray.length; i++) {
				superray[i] = superray[i-1];
			}
			set(index, e);
			size += 1;
		} else {
			throw new IndexOutOfBoundsException("invalid add index");
		}
	}
	
	public String remove(int index) {
		if (inRange(index)) {
			String ret = superray[index];
			for (int i = index; i < superray.length-1; i++) {
				superray[i] = superray[i+1];
			}
			superray[size-1] = null;
			size -= 1;
			if (size <= superray.length/4)
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
		String[]temp = new String[newCapacity];
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


	public String get(int index) {
		if (inRange(index))
			return superray[index];
		throw new IndexOutOfBoundsException("invalid get index");
	}

	public String set(int index, String e) {
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
}
