/* Evan Ordona
 * AP Computer Science
 * Nov 29, 2018
 * LitLife */


import java.util.Random;

public class Life {
	private String first, last, occupation;
	private int looks, smarts, death, age, education, salary, degree;
	private int[] relationships;
	private double money;
	private boolean inSchool;
	
	public Life() {
		first = "FIRST";
		last = "LAST";
		age = -1;
		inSchool = false;
	}
	
	public Life(String f, String l, int a) {
		Random rand = new Random();
		
		first = f;
		last = l;
		age = a;
		looks = rand.nextInt(100);
		smarts = rand.nextInt(100);
		death = rand.nextInt(25);
		money = 0;
		education = -1;
		inSchool = false;
		salary = 0;
		degree = 0;
	}
	
	public String getName() {
		return first + " " + last;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getLooks() {
		return looks;
	}
	
	public int getSmarts() {
		return smarts;
	}
	
	public int getDeath() {
		return death;
	}
	
	public double getMoney() {
		return money;
	}
	
	public int getEducation() {
		return education;
	}
	
	public boolean getInSchool() {
		return inSchool;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public void setDeath(int d) {
		death += d;
	}
	
	public void setAge() {
		age ++;
	}
	
	public void setSmarts(int s) {
		smarts += s;
	}
	
	public void setLooks(int l) {
		looks += l;
	}
	
	public void setMoney(double m) {
		money += m;
	}
	
	public void setEducation(int e) {
		education = e;
	}
	
	public void setInSchool(boolean i) {
		inSchool = i;
	}
	
	public void setSalary(int s) {
		salary = s;
	}
	
	public void adjustSalary(int s) {
		salary += s;
	}
	
	public void setOccupation(String o) {
		occupation = o;
	}
	
	public void setDegree(int d) {
		degree = d;
	}
	
	public void changeStat(String change) {
		if(change.charAt(0) == '+') {
			if (change.charAt(1) == 'l') {
				looks += Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 's') {
				smarts += Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 'd') {
				death += Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 'm') {
				money += Integer.parseInt(change.substring(2));
			}
			
		}
		
		if(change.charAt(0) == '-') {
			if (change.charAt(1) == 'l') {
				looks -= Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 's') {
				smarts -= Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 'd') {
				death -= Integer.parseInt(change.substring(2));
			}
			else if (change.charAt(1) == 'm') {
				money -= Integer.parseInt(change.substring(2));
			}
		}
		
		
	}

}
