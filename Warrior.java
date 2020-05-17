import java.util.Random;

public class Warrior extends Player {
	static Random rand = new Random();
	
	//Bonus Variables
	public static int maxBlock = 50;
	

	public int getHP() {
		return super.getHP() + 10;
	}

	public int getAttackDmg() {
		return super.getAttackDmg() + 10;

	}
	
	public String showClass() {
		return "Warrior";
	}
	
	public int getBlock() {
		int blockChance = rand.nextInt(maxBlock);
		return blockChance;
	}
	
	public int getSpeed() {
		return super.getSpeed() + 5;
	}
}
