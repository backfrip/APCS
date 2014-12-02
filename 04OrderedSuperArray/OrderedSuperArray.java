public class OrderedSuperArray<T extends Comparable<T>> extends SuperArray<T extends Comparable<T>> {
    
    public OrderedSuperArray() {
	super();
    }

    public OrderedSuperArray(int cap) {
	super(cap);
    }

    @Deprecated
    @Override
    public void add(int index, T e) {
	add(e);
    }

    @Override
    public void add(T e) {
	int i = 0;
	while (i < size() && e.compareTo(get(i)) > 0) {
	    i++;
	}
	if (i == size()) {
	    super.add(e);
	} else {
	    super.add(i, e);
	}
    }

}