public class OrderedSuperArray extends SuperArray {

    public OrderedSuperArray() {
	super();
    }

    public OrderedSuperArray(int cap) {
	super(cap);
    }

    /**
     * @deprecated
     * Index determined by class
     */
    @Deprecated
    @Override
    public void add(int index, String e) {
	add(String e);
    }

    @Override
    public void add(String e) {
	if (size() == 0) {
	    super.add(e);
	} else {
	    
	super.add(x, e);
    }