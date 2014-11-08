public class Test {
    
    public static void sop(Object out) {
	System.out.println(out);
    }
    public static void sop() {
	System.out.println();
    }
    
    public static void main(String[]args) {
	
	SuperArray superray = new SuperArray(1);
	sop(superray.size());
	sop(superray);
	sop();
	
	superray.add("Google");
	sop(superray.size());
	sop(superray);
	sop();

	superray.add("Frugal");
	sop(superray.size());
	sop(superray);
	sop();
	
	superray.clear();
	sop(superray.size());
	sop(superray);
	sop();

	superray.add("Dougal");
	sop(superray);
	sop(superray.get(0));
	sop();
	sop(superray.get(1));
	sop();

	superray.add(0, "Foogal");
	sop(superray);
	sop();
	
	sop(superray.remove(0));
	sop(superray);
	sop();
	sop(superray.remove(1));
	sop(superray);
	sop();

	sop(superray.set(0, "Bob"));
	sop(superray);
	sop();
	sop(superray.set(1, "Lucy"));
	sop(superray);
	sop();
	
    }
}
