public class Test {
    //because it takes too long to write :P
    public static void sop(Object o) {
	System.out.println(o);
    }
    public static void main(String[] args) {
	/*
	  OrderedSuperArray<String> osa = new OrderedSuperArray<String>();
	  osa.add("hello");
	  sop(osa);
	  osa.add("jello");
	  sop(osa);
	  osa.add("interrogate");
	  sop(osa);
	  osa.add("abacus");
	  sop(osa);
	  osa.add("cancer");
	  sop(osa);
	
	  OrderedSuperArray<Integer> osai = new OrderedSuperArray<Integer>();
	  osai.add(new Integer(3));
	  osai.add(new Integer(7));
	  osai.add(new Integer(1));
	  osai.add(new Integer(3));
	  sop(osai);

	  //osai.add("ERROR");
	  */
	
	SuperArray<String> sa = new SuperArray<String>();
	sa.add("alpha");
	sa.add("charlie");
	sa.add("delta");
	sa.add("bravo");
	sa.add("echo");
	sa.add("foxtrot");
	sop(sa);
	sa.insertionSort();
	sop(sa);
	
	
    }
    
}