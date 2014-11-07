import java.util.Scanner;
import java.util.Random;

public class Game {
    private static Scanner inStream = new Scanner( System.in );
    private static Random rand = new Random();


    static Adventurer makeCharacter() {
	System.out.print("What is the name of this character?\n> ");
	String name = inStream.nextLine();
	
	Adventurer pc = new Warrior("ERROR DEFAULT CHAR");
	for (boolean exit = false; exit == false;  ) {
	    System.out.print("\nWhat is the class of this character?\n A : Warrior\n B : Wizard\n C : Rogue\n> ");
	    String clss = inStream.nextLine();
	    if (clss.equalsIgnoreCase("A")) {
		pc = new Warrior(name);
		exit = true;
	    } else if (clss.equalsIgnoreCase("B")) {
		pc = new Wizard(name);
		exit = true;
	    } else if (clss.equalsIgnoreCase("C")) {
	        pc = new Rogue(name);
		exit = true;
	    } else {
		System.out.print("\nInvalid input. Please try again.");
	    }
	}
	return allocateStats(pc, 8);
    }	

    static Adventurer allocateStats(Adventurer pc, int points) {
	String clss = pc.getClass().getName();
	int p1, p2, p3;
	for (boolean exit = false; exit == false;  ) {
	    System.out.print("\n"+pc.getStats()+"\nYou have "+points+" stat points to use for this character\n A : Allocate Automatically\n B : Allocate Manually\n> ");
	    String input = inStream.nextLine();

	    if (input.equalsIgnoreCase("A")) {
		int[]p0 = randStats(points);
		p1 = p0[0];
		p2 = p0[1];
		p3 = p0[2];
		if (clss.equals("Warrior")) {
		    addStats(pc, p1, p2, p3);
		} else if (clss.equals("Wizard")) {
		    addStats(pc, p3, p2, p1);
		} else if (clss.equals("Rogue")) {
		    addStats(pc, p2, p1, p3);
		}
		exit = true;
	    } else if (input.equalsIgnoreCase("B")) {
		exit = true;
		for (boolean nexit = false; nexit == false;  ) {
		    System.out.print("\n"+pc.getStats()+"\n"+points+" points remaining\n>STR += ");
		    p1 = inStream.nextInt();
		    System.out.print("\n"+(points-p1)+" points remaining\n>DEX += ");
		    p2 = inStream.nextInt();
		    p3 = points - (p1+p2);
		    System.out.println("\n"+p3+" points remaining\n>INT += "+p3);
		    if (p1 >= 0 && p2 >= 0 && p3 >= 0 && points == p1+p2+p3) {
			addStats(pc, p1, p2, p3);
			nexit = true;
		    } else {
			System.out.print("\nInvalid values! Must be positive and sum up to 8");
		    }
		}
	    } else {
		System.out.print("\nInvalid input. Please try again.");
	    }
	}

	System.out.println("\n"+pc.getStats());
	return pc;
    }
    static Adventurer addStats(Adventurer pc, int STR, int DEX, int INT) {
	pc.setSTR(pc.getSTR()+STR);
	pc.setDEX(pc.getDEX()+DEX);
	pc.setINT(pc.getINT()+INT);
	pc.setHP(pc.maxHP());
	return pc;
    }
    static int[] randStats(int points) {
	int p1 = points/2 + rand.nextInt(2);
	int p2 = points/4 + rand.nextInt(2);
	int p3 = points - (p1+p2);
	int[]ps = {p1,p2,p3};
	return ps;
    }
    
    static Adventurer[] makeParty(Adventurer player) {
	// Currently only supports parties of 2
	String clss = player.getClass().getName();
	Adventurer[]party = {new Rogue("DEFAULT MEMBER ERROR"), new Wizard("DEFAULT MEMBER ERROR")};
	for (boolean exit = false; exit == false;  ) {
	    System.out.print("\nWould you like a default or customized party?\n A : Default\n B : Customized\n> ");
	    String input = inStream.nextLine();
	    
	    if (input.equalsIgnoreCase("A")) {
		Adventurer c1 = new Warrior("Jeremiah");
		addStats(c1, 4, 2, 2);
		Adventurer c2 = new Wizard("Saito");
		addStats(c2, 2, 2, 4);
		Adventurer c3 = new Rogue("Jessica");
		addStats(c3, 2, 4, 2);
		if (clss.equals("Warrior")) {
		    party[0] = c2;
		    party[1] = c3;
		} else if (clss.equals("Wizard")) {
		    party[0] = c1;
		    party[1] = c3;
		} else if (clss.equals("Rogue")) {
		    party[0] = c1;
		    party[1] = c2;
		}
		exit = true;
	    } else if (input.equalsIgnoreCase("B")) {
		System.out.println("\nCreating party member #1");
		Adventurer c1 = makeCharacter();
		System.out.println("\nCreating party member #2");
		Adventurer c2 = makeCharacter();
		party[0] = c1;
		party[1] = c2;
		exit = true;
	    } else {
		System.out.print("\nInvalid input. Please try again.");
	    }	
	}	

	return party;
    }


    static Adventurer generateOpponent() {
	Adventurer opponent = new Warrior("ERROR DEFAULT OPPONENT");
	int a = rand.nextInt(3);
	int[]p0 = randStats(10);
	if (a == 0) {
	    opponent = new Warrior("Opponent");
	    addStats(opponent, p0[0], p0[1], p0[2]);
	} else if (a == 1) {
	    opponent = new Wizard("Opponent");
	    addStats(opponent, p0[2], p0[1], p0[0]);
	} else {
	    opponent = new Rogue("Opponent");
	    addStats(opponent, p0[1], p0[0], p0[2]);
	}
	return opponent;
    }
	    

    static void combat(Adventurer[] party, Adventurer player) {
	Adventurer opponent = generateOpponent();
	boolean youWin = false;
	
	for (boolean end = false; !end;  ) {

	    for (boolean exit = false; !exit;  ) {
		System.out.println("\n** Round Stats **");
		System.out.println(opponent.getStats());
		System.out.println(player.getStats());
		for ( Adventurer pc : party ) {
		    System.out.println(pc.getStats());
		}
		
		delay();
		
		executeAction(player, opponent, getAction(player));
		delay();
		for ( Adventurer pc : party ) {
		    if (!(opponent.isDead())) {
			executeAction(pc, opponent, getAction(pc));
		    }
		    delay();
		}
		System.out.println();
		if (!(opponent.isDead())) {
		    opponentAction(opponent, player, party);
		}
		delay();
		
		if (opponent.isDead()) {
		    exit = true;
		    youWin = true;
		} else if (player.isDead() && partyIsDead(party)) {
		    exit = true;
		    youWin = false;
		}
	    }
	    
	    System.out.println("\n** End of Combat **");
	    if (youWin) {
		System.out.println("You Win! :D");
	    } else {
		System.out.println("You Lost!  D:");
	    }
	    
	    delay();
	    
	    for (boolean exit = false; !exit;  ) {
		System.out.print("\nBattle again?\n Y : Yes\n N : No\n> ");
		String input = inStream.nextLine();
		if (input.equalsIgnoreCase("Y")) {
		    end = false;
		    exit = true;
		    player.restore();
		    for ( Adventurer pc : party ) {
			pc.restore();
		    }
		    opponent.restore();
		} else if (input.equalsIgnoreCase("N")) {
		    end = true;
		    exit = true;
		} else {
		    System.out.print("\nInvalid input. Please try again.");
		}
	    }
	}
		    
    }
    static String getAction(Adventurer pc) {
	if (pc.isDead()) {
	    return "N";
	} else {
	    while (true) {
		System.out.print("\nWhat will " + pc + " do?\n A : Attack\n S : Use Special Attack\n R : Rest\n> ");
		String input = inStream.nextLine();
		if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("S") || input.equalsIgnoreCase("R")) {
		    return input.toUpperCase();
		} else {
		    System.out.print("\nInvalid input. Please try again.");
		}
	    }
	}
    }
    static void executeAction(Adventurer pc, Adventurer target, String action) {
	System.out.println();
	if (action.equals("A")) {
	    pc.attack(target);
	} else if (action.equals("S")) {
	    pc.specialAttack(target);
	} else if (action.equals("R")) {
	    pc.rest();
	}
    }
    static void opponentAction(Adventurer opponent, Adventurer player, Adventurer[] party) {
	// Not a terribly advanced or clean AI here :(
	boolean exit = false;
	Adventurer pc = opponent; // In case of an error, opponent attacks self
	int a = rand.nextInt(10);
	for (int i = 0; i < party.length && exit == false; i++) {
	    if (!(party[i].isDead())) {
		pc = party[i];
		exit = true;

	    }
	}
	if (!exit) {
	    pc = player;
	}
	if (a >= 0 && a < 5) {
	    opponent.attack(pc);
	} else if (a >= 5 && a < 9) {
	    opponent.specialAttack(pc);
	} else {
	    opponent.rest();
	}
    }
    static boolean partyIsDead(Adventurer[]party) {
	boolean res = true;
	for ( Adventurer pc : party ) {
	    if (!(pc.isDead()))
		res = false;
	}
	return res;
    }
		
	
    static void delay() {
	try { // This code copied from the interwebs
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }    
	    
	    
    public static void main(String[]args) {
	System.out.println("=*= WELCOME TO STUYABLO 2 =*=");
	delay();
	System.out.println("*** Create your Adventurer ***");
	Adventurer player = makeCharacter();
	delay();
	System.out.println("\n*** Create your Adventuring Party ***");
	Adventurer[]party = makeParty(player);
	delay();

	System.out.println("\n*** [Combat] ***");
	combat(party, player);

    }

}
