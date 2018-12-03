/* Evan Ordona
 * AP Computer Science
 * Nov 29, 2018
 * LitLife */


import java.util.Random;

public class Life {
	private String first, last, occupation;
	private int looks, smarts, death, age;
	private int[] relationships;
	private double money;
	
	public Life() {
		first = "FIRST";
		last = "LAST";
		age = -1;
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
	
	
	public void setDeath(int d) {
		death += d;
	}
	
	public void setAge() {
		age ++;
	}
	
	public void setSmarts(int s) {
		smarts += s;
	}
	
	public void Looks(int l) {
		looks += l;
	}
	
	public void setMoney(double m) {
		money += m;
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
