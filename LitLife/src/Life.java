
import java.util.Random;

public class Life {
	private String first, last, occupation;
	private int looks, smarts, death, age;
	private int[] relationships;
	
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
		death = 0;
	}
	
	public String getName() {
		return first + " " + last;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int a) {
		age += a;
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

}
