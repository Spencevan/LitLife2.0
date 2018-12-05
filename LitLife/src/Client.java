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
			if((user.getAge() < 7) && (user.getAge() > 1)) {
				r = rand.nextInt(4) * 2;
				
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
		
		if (user.getAge() == 6)
			user.setInSchool(true);
		
		if (user.getAge() == 19) {
			if (user.getInSchool())
				user.setEducation(1);
			
			user.setInSchool(false);
		}
		
		System.out.println("\n" + user.getName());
		System.out.println("Age: " + user.getAge());
		System.out.println("Money: $" + user.getMoney());
		System.out.println("Looks: " + user.getLooks());
		System.out.println("Smarts: " + user.getSmarts());
		System.out.println("Death %: " + user.getDeath());
	
		//ageEvent(user);
		
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
		int choice, officer;
		Random rand = new Random();
		Scanner k = new Scanner(System.in);
		if (user.getAge() < 6) {
			System.out.println("\nYou are not in school yet!");
		} else if (user.getInSchool()) {
				System.out.println("\n1. Study harder");
				System.out.println("2. Drop out");
				System.out.print("Enter your choice:  ");
				choice = k.nextInt();		
				
				if ((choice ==1) && (studied == false)) {
					studied = true;
					user.setSmarts(rand.nextInt(3));
				} else if (choice == 2) {
					user.setInSchool(false);
					System.out.println("You have dropped out of school.");
				}
		}
		else {
			System.out.println("\n1. Education");
			System.out.println("2. Jobs");
			System.out.println("3. Military");
			System.out.print("Enter your choice:  ");
			choice = k.nextInt();
			
			if (choice == 1) {
				//Leedle Leedle Lee
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				System.out.println("\n1. Army");
				System.out.println("2. Navy");
				System.out.println("3. Air Force");
				System.out.println("4. Marines");
				System.out.println("5. Coast Guard");
				System.out.print("Enter your choice:  ");
				choice = k.nextInt();
				
				System.out.println("\n1. Enlist in the military  ");
				System.out.println("2. Become an officer  ");
				System.out.print("Enter your choice:  ");
				officer = k.nextInt();
				
				if ((officer == 2) && (user.getSmarts() > 64)) {
					if (choice == 1) {
						System.out.println("Congratulations! You are now an Army officer and will be paid $35,664 a year.");
						user.setOccupation("Army Officer");
						user.setSalary(35664);
					} else if (choice == 2) {
						System.out.println("Congratulations! You are now a Naval officer and will be paid $35,664 a year.");
						user.setOccupation("Naval Officer");
						user.setSalary(35664);
					} else if (choice == 3) {
						System.out.println("Congratulations! You are now an Air Force officer and will be paid $35,664 a year.");
						user.setOccupation("Air Force Officer");
						user.setSalary(35664);
					} else if (choice == 4) {
						System.out.println("Congratulations! You are now a Marines officer and will be paid $35,664 a year.");
						user.setOccupation("Marines Officer");
						user.setSalary(35664);
					} else if (choice == 5) {
						System.out.println("Congratulations! You are now a Coast Guard officer and will be paid $35,664 a year.");
						user.setOccupation("Coast Guard Officer");
						user.setSalary(35664);
					}
				} else if (officer == 2) {
					System.out.println("Unfortunately your application for becoming an officer was denied.");
				} else if (officer == 1) {
					if (choice == 1) {
						System.out.println("Congratulations! You are now an Army solider and will be paid $27,985 a year.");
						user.setOccupation("Army Soldier");
						user.setSalary(27985);
					} else if (choice == 2) {
						System.out.println("Congratulations! You are now a Navy sailor and will be paid $27,985 a year.");
						user.setOccupation("Navy Sailor");
						user.setSalary(27985);
					} else if (choice == 3) {
						System.out.println("Congratulations! You are now an Air Force Pilot and will be paid $27,985 a year.");
						user.setOccupation("Air Force Pilot");
						user.setSalary(27985);
					} else if (choice == 4) {
						System.out.println("Congratulations! You are now a Marine and will be paid $27,985 a year.");
						user.setOccupation("Marine");
						user.setSalary(27985);
					} else if (choice == 5) {
						System.out.println("Congratulations! You are now a Coast Guard Sailor and will be paid $27,985 a year.");
						user.setOccupation("Coast Guard Sailor");
						user.setSalary(27985);
					}
				}
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
