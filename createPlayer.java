

public class createPlayer extends Player {
	public String name;
	
	public static Object CreatePlayer() {

		Object player = new createPlayer();
		
		// prompt user for name
		System.out.print("Name?: ");
		String name = console.next();

		// capitalize users name
		player = name.substring(0, 1).toUpperCase() + name.substring(1);
		
		System.out.println("Welcome to the dungeon, " + player + "!\n");
		
		return player;
		
		
	}
}
