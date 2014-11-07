import java.util.Random;

public class Wizard extends Adventurer {
    private int mana;

    // Constructor
    public Wizard(String name) {
	super(name, 8, 8, 8);
	setMana(20);
    }

    // set/get methods
    int getMana() {
	return mana;
    }

    void setMana(int n) {
	mana = n;
    }

    // Class methods
    String getStats() {
	return super.getStats() + " " + getMana() + " mana";
    }

    int maxHP() {
	return maxHP(10);
    }

    void attack(Adventurer other) {
        if (hit(other) || hit(other)) {
	    Random rand = new Random();
	    int damage = getSTR()/5 + rand.nextInt(2);
	    System.out.println(this + " whacks " + other + " with a stick for " + damage + " points of damage");
	    other.damage(damage);
	} else {
	    System.out.println(this + "'s attack misses -_-");
	}
    }

    void specialAttack(Adventurer other) {
        if (getMana() >= 5) {
	    setMana(getMana()-5);
	    if (magicHit(other)) {
		Random rand = new Random();
		int damage = (getINT() + getINT()/2 + rand.nextInt(getINT()/2+2)) / 2 + getINT()/4;
		System.out.println(this + " hurls arcance energy at " + other + " and deals " + damage + " points of damage");
		other.damage(damage);
	    } else {
		System.out.println(this + "'s attack misses!");
	    }
	} else {
	    System.out.println("Not enough mana!");
	    attack(other);
	}
    }

    void rest() {
	Random rand = new Random();
	int regen = 2 + rand.nextInt(getINT()/4+1);
	int newMana = getMana() + regen;
	if (newMana <= 20) {
	    setMana(newMana);
	    System.out.println(restHP() + " and " + regen + " mana");
	} else {
	    setMana(20);
	    System.out.println(restHP() + " and " + (regen - (newMana - 20)) + " mana");
	}
    }

    void restore() {
	super.restore();
	setMana(20);
    }
	
}
