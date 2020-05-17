import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();

		boolean running = true;

		// create player
		Player player = Player.createPlayer();
		Player p = Player.chooseClass();
		String pclass = p.showClass();

		// variables
		int potions = Player.getNumHealPotions();
		int hp = p.getHP();
		int potionChance = p.getHpPotionChance();
		int block = p.getBlock();
		int pSpeed = p.getSpeed();
		
		starLine(50);

		GAME: while (running) {
			int enemyHealth = Enemy.getEnemyHP();
			int eSpeed = Enemy.getEnemySpeed();
			String enemy = Enemy.enemies[rand.nextInt(Enemy.enemies.length)];
			
			System.out.println("\tYou have encountered a " + enemy + "!!\n");

			while (enemyHealth >= 0) {
				System.out.println("Your HP: " + hp);
				System.out.println("Enemy HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potions");
				System.out.println("\t3. Run!");
				starLine(50);
				String i = console.nextLine();

				if (i.equals("1")) {
					int dmgDealt = rand.nextInt(p.getAttackDmg());
					int dmgTaken = Enemy.getEnemyDmg();
					
					enemyHealth -= dmgDealt;
					hp -= dmgTaken;
					
					if (pSpeed > eSpeed) {
						System.out.println("You went first first.");
					} else if (eSpeed > pSpeed) {
						System.out.println(enemy + " went first.");
					}
					

					if (pclass.equals("Warrior") && (rand.nextInt(100) < block)) {

						System.out.println("> You blocked an entire attack with your shield!\n");

						hp += dmgTaken;

						System.out.println("\t> You hit the " + enemy + " for " + dmgDealt + " damage.\n");

					} else {

						System.out.println("\t> You hit the " + enemy + " for " + dmgDealt + " damage total.");

						System.out.println("");

						System.out.println("\t> You recieve " + dmgTaken + " in retaliation\n");
					}

					if (hp < 1) {
						System.out.println("\t You have taken too much damage..\n");
						starLine(50);
						break;
					}

				} else if (i.equals("2")) {
					if (potions > 0) {
						hp += p.getPotionHealAmt();
						potions--;
						System.out.println(
								"\tYou drink a health potion for " + p.getPotionHealAmt() + ".\n\t You now have " + hp
										+ "HP" + "\n\t You have " + potions + " health potions left.\n");
						starLine(50);
					} else {
						System.out.println("You have no health potions left, defeat enemy for a chance for more!");
						starLine(50);
					}
				} else if (i.equals("3")) {
					System.out.println("\t You run away from the " + enemy + "!");
					continue GAME; // returns to start of encounter (GAME)
				} else {
					System.out.println("\tInvalid Input");
				}
				
				//ADD EXP LEVELS & DUNGEON LEVEL INCREASE
				
			}
			if (hp < 1) {
				System.out.println("\t~GAME OVER~");
				break;
			}

			starLine(50);
			System.out.println("\t~ " + enemy + " was defeated! ~");
			System.out.println("\t~ You have " + hp + " HP left. ~");
			if (rand.nextInt(100) > potionChance) {
				potions++;
				System.out.println("\tThe " + enemy + " dropped a health potion! ");
				System.out.println("\tYou have " + potions + " health potions left.\n");
				starLine(50);
			}
		}

	}

	public static void starLine(int n) {

		if (n == 0) {
			System.out.println();
		} else {
			// recursive case; print one more star
			System.out.print("*");
			starLine(n - 1);
		}

	}
}