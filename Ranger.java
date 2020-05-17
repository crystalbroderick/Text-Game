
public class Ranger extends Player {
	
	// Bonus: speed
	
	public int getHP() {
		return super.getHP() + 5;
	}

	public int getAttackDmg() {
		return super.getAttackDmg() + 15;

	}
	
	public int getSpeed() {
		return super.getSpeed() + 10;
	}
}
