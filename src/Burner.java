
public class Burner {
	public static final int TIME_DURATION = 2;

	public enum Temperature {
		BLAZING("VERY HOT! DON'T TOUCH"), 
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
	
	public void increaseTemp() {
		if (myTemperature != Temperature.BLAZING) {
			myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
		}
	}
	
	public void decreaseTemp() {
		if (myTemperature != Temperature.COLD) {
			myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
		}
	}
	
	
	public void updateTemperature() {

	    // Only count down if a temperature change is in progress
	    if (timer > 0) {
	        timer--;
	    }

	    // Don't change temperature until the timer reaches 0
	    if (timer != 0) {
	        return;
	    }

	    // HEATING
	    if (myTemperature == Temperature.COLD && mySetting != Setting.OFF) {
	        increaseTemp();
	    }
	    else if (myTemperature == Temperature.WARM &&
	            (mySetting == Setting.MEDIUM || mySetting == Setting.HIGH)) {
	        increaseTemp();
	    }
	    else if (myTemperature == Temperature.HOT &&
	            mySetting == Setting.HIGH) {
	        increaseTemp();
	    }

	    // COOLING
	    else if (myTemperature == Temperature.BLAZING &&
	            mySetting != Setting.HIGH) {
	        decreaseTemp();
	    }
	    else if (myTemperature == Temperature.HOT &&
	            (mySetting == Setting.LOW || mySetting == Setting.OFF)) {
	        decreaseTemp();
	    }
	    else if (myTemperature == Temperature.WARM &&
	            mySetting == Setting.OFF) {
	        decreaseTemp();
	    }

	    // If we're still not at the temperature that matches the setting,
	    // wait another TIME_DURATION minutes before changing again.
	    if (
	        (mySetting == Setting.OFF && myTemperature != Temperature.COLD) ||
	        (mySetting == Setting.LOW && myTemperature != Temperature.WARM) ||
	        (mySetting == Setting.MEDIUM && myTemperature != Temperature.HOT) ||
	        (mySetting == Setting.HIGH && myTemperature != Temperature.BLAZING)
	    ) {
	        timer = TIME_DURATION;
	    }
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

