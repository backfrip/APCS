public class Driver {
    public static void main(String[]args) {
	
	Adventurer DeAd = new Adventurer();
	Adventurer MoAd = new Adventurer("Jeff", 19);
	Warrior DeWar = new Warrior();
	Warrior MoWar = new Warrior("Roger", 9000, 1);
	Wizard DeWiz = new Wizard();
	Wizard MoWiz = new Wizard("Lucy", 50, 20);

	System.out.println(DeAd.getName() + "-" + DeAd.getHP());
	System.out.println(MoAd.getName() + "-" + MoAd.getHP());
	System.out.println(DeWar.getName() + "-" + DeWar.getHP() + "-" + DeWar.getBonusHealth());
	System.out.println(MoWar.getName() + "-" + MoWar.getHP() + "-" + MoWar.getBonusHealth());
	System.out.println(DeWiz.getName() + "-" + DeWiz.getHP() + "-" + DeWiz.getMana());
	System.out.println(MoWiz.getName() + "-" + MoWiz.getHP() + "-" + MoWiz.getMana());
	
       

    }
}