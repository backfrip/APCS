import java.util.Random;

public class Rogue extends Adventurer {
    private int stamina;
    
    // Constructor
    public Rogue(String name) {
	super(name, 8, 8, 8);
	setStamina(20);
    }

    // set/get methods
    int getStamina() {
	return stamina;
    }
    
    void setStamina(int n) {
	stamina = n;
    }

    // Class methods
    String getStats() {
	return super.getStats() + " " + getStamina() + " stamina";
    }

    int maxHP() {
	return maxHP(12);
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
	if (getStamina() >= 5) {
	    setStamina(getStamina()-5);
	    if (hit(other) || hit(other)) {
		Random rand = new Random();
		int damage = getSTR()/2 + rand.nextInt(getDEX()/4) + rand.nextInt(2);
		System.out.println(this + " backstabs " + other + " for " + damage + " points of damage");
		other.damage(damage);
	    } else {
		System.out.println(this + "'s attack misses!");
	    }
	} else {
	    System.out.println("Not enough stamina!");
	    attack(other);

	}
    }

    void rest() {
	Random rand = new Random();
	int regen = 2 + rand.nextInt((getINT()+getSTR())/8+1);
	int newStamina = getStamina() + regen;
	if (newStamina <= 20) {
	    setStamina(newStamina);
	    System.out.println(restHP() + " and " + regen + " stamina");
	} else {
	    setStamina(20);
	    System.out.println(restHP() + " and " + (regen - (newStamina - 20)) + " stamina");
	}
    }
    
    void restore() {
	super.restore();
	setStamina(20);
    }

}
