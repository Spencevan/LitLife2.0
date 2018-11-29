
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Client {
	
	public static void ageEvent() throws IOException {
		String[] events = new String[10];
		BufferedReader inFile1 = new BufferedReader(new FileReader(new File ("names.txt")));
		
		
	}
	
	public static boolean menu(Life user, Life[] parents, int money, boolean dead) throws IOException {
		int choice;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n" + user.getName());
		System.out.println("Age: " + user.getAge());
		System.out.println("Money: " + money);
		System.out.println("Looks: " + user.getLooks());
		System.out.println("Smarts: " + user.getSmarts());
		System.out.println("Death %: " + user.getDeath());
		
		System.out.println("\n1. Age");
		System.out.println("2. Kill yourself.");
		System.out.print("\nEnter your choice: ");
		
		choice = scan.nextInt();
		
		if(choice ==1) {
			user.setAge(1);	
			ageEvent();
		} 
		else if (choice == 2) {
			dead = true;
		}
		
		return dead;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(new File ("names.txt")));
		Random rand = new Random();
		int age, money = 0;
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
		age = rand.nextInt(40);
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
			dead = menu(user, parents, money, dead);
		}
		
		System.out.println("\nYou have died.");
		inFile.close();
	}

}
