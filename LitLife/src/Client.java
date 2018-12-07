 /* Evan Ordona
 * AP Computer Science
 * Nov 29, 2018
 * LitLife */



import java.io.*;
import java.util.*;

public class Client {
	
	public static void ageEvent(Life user) {
		user.setMoney(user.getSalary());
		
		user.setMoney(-(user.getMoney() * .20));
		
		if (user.getAge() == 6) {
			user.setInSchool(true);
			System.out.println("You have started elementary school.");
		}
		
		if (user.getAge() == 19) {
			if (user.getInSchool())
				user.setEducation(1);
			
			System.out.println("You have graduated high school.");
			user.setInSchool(false);
		}
		
		if (user.getEducation() > 33)
			user.setEducation(user.getEducation() + 1);
		
		if (user.getEducation() > 38)
			user.setEducation(user.getEducation() + 1);
		
		if (user.getEducation() == 38) {
			user.setEducation(user.getDegree());
			user.setInSchool(false);
			System.out.println("You have graduated from college! Welcome to the real world.");
		}
		
		if (user.getEducation() == 42) {
			user.setEducation(user.getDegree());
			user.setInSchool(false);
			System.out.println("You have graduated from Professional School! Welcome to the really real world.");
		}
	}
	
	public static boolean menu(Life user, Life[] parents, boolean dead) throws IOException {
		int choice;
		Scanner scan = new Scanner(System.in);
		boolean studied = false;
			
		System.out.println("\n" + user.getName());
		System.out.println("Age: " + user.getAge());
		System.out.println("Money: $" + user.getMoney());
		System.out.println("Looks: " + user.getLooks());
		System.out.println("Smarts: " + user.getSmarts());
		System.out.println("Death %: " + user.getDeath());
	
		
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
			ageEvent(user);
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
				System.out.println("\n1. GED");
				System.out.println("2. University");
				System.out.println("3. Medical School");
				System.out.println("4. Law School");
				System.out.println("5. Dentistry School");
				System.out.print("Enter your choice  ");
				choice = k.nextInt();
				
				if (choice == 1) { 
					if ((user.getSmarts() > 9) && (user.getEducation() == 0) && (user.getAge() > 17)) {
						System.out.println("\nCongratulations! You now have your GED. It cost $1,000.");
						user.setEducation(1);
						user.setMoney(-1000);
					} else if (user.getEducation() == 1) {
						System.out.println("\nYou already have your GED.");
					} else if ((user.getEducation() == 0) && (user.getSmarts() < 10)) {
						System.out.println("\nYou failed to pass your GED test. Dummy!");
					} else {
						System.out.println("You must be 18 or older to get your GED");
					}
				} else if ((choice == 2) && (user.getEducation() == 1)) {
					System.out.println("\n1. Caldwell University");
					System.out.println("2. Rutgers University");
					System.out.println("3. Harvard University");
					System.out.print("Enter your choice:  ");
					choice = k.nextInt();
					
					if (choice == 1) {
						if (user.getSmarts() > 24) {
							System.out.println("You have been accepted into Caldwell University. Your tuition will be $31,200.");
							user.setInSchool(true);
							user.setEducation(34);
							user.setMoney(-124800);
						} else {
							System.out.println("Your application to Caldwell University was denied.");
						}
					} else if (choice == 2) {
						if (user.getSmarts() > 49) {
							System.out.println("You have been accepted into Rutgers University. Your tuition will be $14,131.");
							user.setInSchool(true);
							user.setEducation(34);
							user.setMoney(-56524);
						} else {
							System.out.println("Your application to Caldwell University was denied.");
						}
					} else if (choice == 3) {
						if (user.getSmarts() > 89) {
							System.out.println("You have been accepted into Harvard University. Your tuition will be $45,278.");
							user.setInSchool(true);
							user.setEducation(34);
							user.setMoney(-181112);
						} else {
							System.out.println("Your application to Harvard University was denied.");
						}
					}
				} else if (choice == 2) {
					System.out.println("You must get your GED before going to college.");
				} else if (choice == 3) {
					if ((user.getEducation() ==  7) || (user.getEducation() == 17) || (user.getEducation() == 27)) {
						if (user.getSmarts() > 79) {
							System.out.println("You have been accepted to med school. Your tuition will be $34,592.");
							user.setInSchool(true);
							user.setEducation(39);
							user.setMoney(-69184);
						} else {
							System.out.println("Your application to Med School was denied.");
						}
					} else {
						System.out.println("You are not qualified to attend Med School.");
					}
				} else if (choice == 4) {
					if ((user.getEducation() ==  8) || (user.getEducation() == 18) || (user.getEducation() == 28)) {
						if (user.getSmarts() > 79) {
							System.out.println("You have been accepted to Law School. Your tuition will be $39,612.");
							user.setInSchool(true);
							user.setEducation(39);
							user.setMoney(-79224);
						} else {
							System.out.println("Your application to Law School was denied.");
						}
					} else {
						System.out.println("You are not qualified to attend Law School.");
					}
				} else if (choice == 5) {
					if ((user.getEducation() ==  9) || (user.getEducation() == 19) || (user.getEducation() == 29)) {
						if (user.getSmarts() > 79) {
							System.out.println("You have been accepted to Dentistry School. Your tuition will be $67,399.");
							user.setInSchool(true);
							user.setEducation(39);
							user.setMoney(-134278);
						} else {
							System.out.println("Your application to Dentistry School was denied.");
						}
					} else {
						System.out.println("You are not qualified to attend Dentistry School.");
					}
				}
				
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
