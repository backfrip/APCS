public class Wizard extends Adventurer {
    private int mana;

    public Wizard() {
	this("Tim", 20, 10);
    }

    public Wizard(String name, int HP, int mana) {
	super(name, HP);
	setMana(10);
    }

    public void setMana(int mana) {
	this.mana = mana;
    }

    public int getMana() {
	return mana;
    }

}