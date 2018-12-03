/* Evan Ordona
 * AP Computer Science
 * Nov 29, 2018
 * LitLife */



import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Client {
	
	public static void ageEvent(Life user) throws IOException {
		String[] events = new String[10];
		Random rand = new Random();
		int r;
		String change = "";
		BufferedReader inFile1 = new BufferedReader(new FileReader(new File ("ageEvents.txt")));
		for (int i=0; i<10; i++){
			events[i] = inFile1.readLine();
		}
		
		if(rand.nextInt(9) < 4) {
			if(user.getAge() < 7) {
				r = rand.nextInt(7);
				while((r % 2) != 0)
					r = rand.nextInt(7);
				
				System.out.println("\n" + events[r]);
				change = events[r+1];
			}
			
			user.changeStat(change);
		}
		
		if(user.getAge() == 6)
			System.out.println("\nYou started elementary school.");
		else if (user.getAge() == 11)
			System.out.println("\nYou begin attending Grover Cleveland Middle School.");
		else if (user.getAge() == 14)
			System.out.println("\nYou start your journey at the place of possiblities, James Caldwell High School.");
		
	}
	
	public static boolean menu(Life user, Life[] parents, boolean dead) throws IOException {
		int choice;
		Scanner scan = new Scanner(System.in);
		boolean studied = false;
		
		System.out.println("\n" + user.getName());
		System.out.println("Age: " + user.getAge());
		System.out.println("y: $" + user.getMoney());
		System.out.println("Looks: " + user.getLooks());
		System.out.println("Smarts: " + user.getSmarts());
		System.out.println("Death %: " + user.getDeath());
		
		ageEvent(user);
		
		System.out.println("\n1. Age");
		System.out.println("2. Scholastics and Occupation");
		System.out.println("3. Relationships");
		System.out.println("4. Activities");
		System.out.println("5. Kill yourself.");
		System.out.print("\nEnter your choice: ");
		
		choice = scan.nextInt();
		
		if(choice ==1) {
			studied = false;
			user.setAge();
		} 
		else if (choice == 2)
			school(user, studied);
		else if (choice == 3)
			relationships();
		else if (choice == 4)
			activities();
		else if (choice == 5) {
			dead = true;
		}
		
		return dead;
	}
	
	public static void school(Life user, boolean studied) {
		int choice;
		Random rand = new Random();
		Scanner k = new Scanner(System.in);
		
		if (user.getAge() < 19 ) {
			System.out.println("\n1. Study harder");
			System.out.println("2. Drop out");
			choice = k.nextInt();
			
			
			if ((choice ==1) && (studied == false)) {
				studied = true;
				
			}
		}
	}
	
	public static void relationships() {
		
	}
	
	public static void activities() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(new File ("names.txt")));
		Random rand = new Random();
		int age;
		String first, last;
		String[] names = new String[30];
		Life user;
		Life[] parents = new Life[2];
		boolean dead = false;
		
		//Reads in all the names and puts it in an array
		for (int i=0; i < 30; i++) {
			names[i] = inFile.readLine();	
		}
		
		//Makes a first and last name then creates the user object
		first = names[rand.nextInt(14)];
		last = names[rand.nextInt(15) + 15];
		
		user = new Life(first, last, 1);
		
		//Makes a new first name and makes and age at least 18 for the dad and creates that object
		first = names[rand.nextInt(8)];
		age = rand.nextInt(50);
		while (age < 17)
			age += rand.nextInt(5); 
		
		parents[0] = new Life(first, last, age);
		
		//Makes a new first and last name and age for the mom and then creates the object
		first = names[rand.nextInt(6) + 8];
		last = names[rand.nextInt(15) + 15];
		age = rand.nextInt(40);
		while (age < 18)
			age += rand.nextInt(5); 
		
		parents[1] = new Life(first, last, age);
		
		//Output once saying who you are and ur parents
		System.out.println("Your mom, " + parents[1].getName() +", and dad, " + parents[0].getName() + " gave you the name " + user.getName() + ".");
		
		//MAIN MENU CALL - menu returns boolean and runs until games over
		while(dead == false) {
			dead = menu(user, parents, dead);
		}
		
		System.out.println("\nYou have died.");
		inFile.close();
	}

}
