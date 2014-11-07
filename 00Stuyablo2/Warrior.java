import java.util.Random;

public class Warrior extends Adventurer {
    private int rage;

    // Constructor
    public Warrior(String name) {
	super(name, 8, 8, 8);
	setRage(0);
    }

    // set/get methods
    int getRage() {
	return rage;
    }
    
    void setRage(int n) {
	rage = n;
    }

    // Class methods
    String getStats() {
	return super.getStats() + " " + getRage() + " rage";
    }

    int maxHP() {
	return maxHP(14);
    }

    void enrage(int rageIncrease) {
	int newRage = getRage() + rageIncrease;
	if (newRage <= 20) {
	    setRage(newRage);
	} else {
	    setRage(20);
	}
	System.out.println(this + "'s rage increases...");
    }

    void damage(int rawDamage) {
	super.damage(rawDamage);
	int rageIncrease = (int)(rawDamage/1.5);
	enrage(rageIncrease);
    } 

    void attack(Adventurer other) {
	if (hit(other) || hit(other)) {
	    Random rand = new Random();
	    int damage = getSTR()/3 + rand.nextInt(3);
	    System.out.println(this + " attacks " + other + " for " + damage + " points of damage");
	    other.damage(damage);
	} else {
	    System.out.println(this + "'s attack misses!");
	}
    }

    void specialAttack(Adventurer other) {
	if (getRage() >= 4) {
	    setRage(getRage()-4);
	    if (hit(other)) {
		Random rand = new Random();
		int damage = getSTR()/2 + rand.nextInt(3) + 2;
		System.out.println(this + " goes beserk and injures " + other + " for " + damage + " points of damage");
		other.damage(damage);
	    } else {
		System.out.println(this + "'s attack misses!");
	    }
	} else {
	    System.out.println("Not enough rage!");
	    attack(other);
	}
    }

    void rest() {
        System.out.println(restHP());
    }

    void restore() {
	super.restore();
	setRage(0);
    }
    
}
