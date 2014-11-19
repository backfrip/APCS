public class Warrior extends Adventurer {
    private int bonusHealth;
    
    public Warrior() {
	this("Sasuki", 20, 10);
    }

    public Warrior(String name, int HP, int bonusHealth) {
	super(name, HP);
	setBonusHealth(bonusHealth);
    }

    public void setBonusHealth(int bonusHealth) {
	this.bonusHealth = bonusHealth;
    }
    
    public int  getBonusHealth() {
	return bonusHealth;
    }

    public int getHP() {
	return super.getHP() + getBonusHealth();
    }
}