public class OrderedSuperArray<T extends Comparable<T>> extends SuperArray<T> {
    
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
    
    @Override
    public int find(T target) {
	double r = size();
	int i = size()/2;
	while (r != 0) {
	    r = Math.ceil(r/2);
	    if (get(i).equals(target))
		return i;
	    if (get(i).compareTo(target) < 0)
		i += r/2;
	    else
		i -= r/2;
	}
	return -1;
    }

}