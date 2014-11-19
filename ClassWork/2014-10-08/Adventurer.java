public class Adventurer {
    private String name;
    private int HP, STR, DEX, INT;

    public Adventurer() {
	this("Lester");
    }

    public Adventurer(String name) {
	setName(name);
	setHP(20);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getHP() {
	return HP;
    }

    public void setHP(int HP) {
	this.HP = HP;
    }
    
    public void attack() {
	// Nothing to C here!
    }

    public void specialAttack() {
	// Nothing to C here!
    }

}
