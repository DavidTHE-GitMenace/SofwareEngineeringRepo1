
public class Burner {
	public static final int TIME_DURATION = 2;

	public enum Temperature {
		BLAZING("VERY HOT!"), 
		HOT("CAREFUL"), 
		WARM("warm"), 
		COLD("cooool");
		
		private String temp;

		Temperature (String t) {
			temp = t;
		}
		
		public String toString() {
			return temp;
		}
	}
	
	
	
	// private variable 
	private Temperature myTemperature;
	public Setting mySetting;
	public int timer;
	
	public Burner () {
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
	}
	
	public void plusButton() {
		if (this.mySetting == Setting.OFF) {
			this.mySetting = Setting.LOW;
		}
		else if (this.mySetting == Setting.LOW) {
			this.mySetting = Setting.MEDIUM;
		}
		else if (this.mySetting == Setting.MEDIUM) {
			this.mySetting = Setting.HIGH;
		}
		this.timer = TIME_DURATION; 
	}
	
	public void minusButton() {
		if (this.mySetting == Setting.HIGH) {
			this.mySetting = Setting.MEDIUM;
		}
		else if (this.mySetting == Setting.MEDIUM) {
			this.mySetting = Setting.LOW;
		}
		else if (this.mySetting == Setting.LOW) {
			this.mySetting = Setting.OFF;
		}
		this.timer = TIME_DURATION; 
	}
	
	public void updateTemperature() {
		if (this.myTemperature == Temperature.COLD) {
			this.mySetting = Setting.MEDIUM;
		}
		else if (this.mySetting == Setting.MEDIUM) {
			this.mySetting = Setting.LOW;
		}
		else if (this.mySetting == Setting.LOW) {
			this.mySetting = Setting.OFF;
		}
		this.timer--;

	}
	
	public void display() {
		System.out.println("[" + mySetting + "]" + "....." + myTemperature);
	}
	
	
	public Temperature getTemperature() {
		return myTemperature;
	}
	
	public static void main(String[] args) {
		Burner a = new Burner();
		a.display();
	}
}

