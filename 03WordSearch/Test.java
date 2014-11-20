public class Test {
	public static void main(String[]args) {
		WordGrid bord = new WordGrid(4,4);
		System.out.println(bord.addWordHorizontal("PING",0,0));
		System.out.println(bord.addWordHorizontal("PONG",1,0));
		System.out.println(bord.addWordHorizontal("ING",2,1));
		System.out.println(bord.addWordHorizontal("SIN",2,0));
		System.out.println(bord.addWordHorizontal("GROUCHOMARX",3,0));
		System.out.println(bord.addWordHorizontal("A",3,3));
		System.out.println(bord);
	}
}