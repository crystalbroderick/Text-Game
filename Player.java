import java.io.Console;
import java.util.Scanner;

public class Player {
	String name;
	public int HP;
	public int AttackDmg;
	static Scanner console = new Scanner(System.in);
	public static int potions;

	public static Player createPlayer() {

		// prompt user for name
		System.out.print("Name?: ");
		String name = console.next();

		// capitalize users name
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		System.out.println("Welcome to the dungeon, " + name + "!\n");
		return null;
		
	}

	public static Player chooseClass() {
		// pick player class
		System.out.println("Choose a class");
		System.out.println("1. Warrior\n2. Mage\n3. Ranger");
		String pclass = console.next();

		switch (pclass) {

		case ("Warrior"):
		case ("1"):
			return new Warrior();
		case ("Mage"):
		case ("2"):
			return new Mage();
		case ("Ranger"):
		case ("3"):
			return new Ranger();
		default:
			System.out.println("Invalid");
		}
		return null;

	}
	
	public String showClass() {
		return "Player";
	}
	
	public static int getNumHealPotions() {
		int numHPPotions = 3;
		return numHPPotions;
	}
	
	public int getPotionHealAmt() {
		int hpHealAmt = 30;
		return hpHealAmt;
	}
	
	public int getHpPotionChance() {
		int hpPotionDC = 50;	//percentage
		return hpPotionDC;
	}

	public int getHP() {
		int hp = 100;
		return hp;
	}
	
	public int getAttackDmg() {
		return 5;
	}

	public int getBlock() {
		int blockChance = 0;
		return blockChance;
	}
	
	public int getSpeed() {
		return 0;
	}
	
	
}
/*
 * // print stats if (pclass.equals("w")) { Warrior player = new Warrior();
 * System.out.println("Print Starting Stats? Y/N"); String ans = console.next();
 * if (ans.equalsIgnoreCase("Y")) { System.out.println("health: " +
 * player.getHP()); System.out.println("damage: " + player.getAttackDmg()); } }
 * else { System.out.println("Sorry that's not available at this time!");
 * 
 * }
 */
