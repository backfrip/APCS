public class Test {
    
    // Note to self: make Sublime Text indent with spaces for emacs consitency
    
    public static void main(String[]args) {
	WordGrid bord = new WordGrid(4,4);
	System.out.println(bord.addWordHorizontal("PING",0,0));
	System.out.println(bord.addWordHorizontal("PONG",1,0));
	System.out.println(bord.addWordHorizontal("ING",2,1));
	System.out.println(bord.addWordHorizontal("SIN",2,0));
	System.out.println(bord.addWordHorizontal("GROUCHOMARX",3,0));
	System.out.println(bord.addWordVertical("GGG",0,3));
	System.out.println(bord.addWordVertical("GGGA",3,0));
	System.out.println(bord.addWordVertical("PPSS",0,0));
	System.out.println(bord.addWordDiagonal("PONG",0,0));
	System.out.println(bord.addWordDiagonal("PIN",1,0));
	System.out.println(bord.addWordDiagonal("SO",2,0));
	
	System.out.println("\n"+bord);
    }
}