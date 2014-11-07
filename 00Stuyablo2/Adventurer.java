import java.util.Random;

public abstract class Adventurer {
    private String name;
    private int HP, STR, DEX, INT;

    // Constructor
    public Adventurer(String name, int STR, int DEX, int INT) {
	this.name = name;
	setSTR(STR);
	setDEX(DEX);
	setINT(INT);
	setHP(maxHP());
    }

    // set/get methods
    int getHP() {
	return HP;
    }

    void setHP(int n) {
	HP = n;
    }
    
    int getSTR() {
	return STR;
    }
    
    void setSTR(int n) {
	STR = n;
    }

    int getDEX() {
	return DEX;
    }

    void setDEX(int n) {
	DEX = n;
    }

    int getINT() {
	return INT;
    }
    
    void setINT(int n) {
	INT = n;
    }

    // toString override and getFullName
    public String toString() {
	return name;
    }

    String getFullName() {
	return "[" + this.getClass().getName() + "] " + this;
    } 
	   

    // Class methods
    String getStats() {
	return this.getFullName() + "-- " + HP + "HP " + STR + "STR " + INT + "INT " + DEX + "DEX";
    }

    boolean isDead() {
	if (HP <= 0)
	    return true;
	return false;
    }

    abstract int maxHP(); // Provides base by class
    int maxHP(int base) {
	return base + getSTR();
    }

    private boolean hit(Adventurer other, int type) {
	// alpha hit algorithm
	// type 0 - phyiscal, type 1 - magical;
	double chance;
	int stat = 0;
	Random rand = new Random();

	if (type == 0) {
	    stat = getDEX();
	} else if (type == 1) {
	    stat = (getINT()*2 + getDEX()) / 3; // Approximate weighted average of INT and DEX
	}
	
	if ( stat >= other.getDEX() ) {
	    chance = (50.0 + stat - other.getDEX()) / 100;
	} else {
	    chance = (50.0 + other.getDEX() - stat) / 100;
	}

	if (rand.nextDouble() <= chance) {
	    return true;
	}
	return false;	
    }

    boolean hit(Adventurer other) {
	return hit(other, 0);
    }

    boolean magicHit(Adventurer other) {
	return hit(other, 1);
    }

    void damage(int rawDamage) {
	setHP(HP - rawDamage);
    }

    abstract void attack(Adventurer other);
    abstract void specialAttack(Adventurer other);

    String restHP() {
	Random rand = new Random();
	int regen = rand.nextInt((getSTR() + getINT())/5) + rand.nextInt(3) + 1;
        int newHP = getHP() + regen;
	if (newHP <= maxHP()) {
	    setHP(newHP);
	    return this + " regains " + regen + "HP";
	} else {
	    setHP(maxHP());
	    return this + " regains " + (regen - (newHP - maxHP())) + "HP";
	}
    }
    abstract void rest();

    void restore() {
	setHP(maxHP());
    }

}
