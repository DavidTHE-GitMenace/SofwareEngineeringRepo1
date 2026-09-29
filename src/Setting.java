
public enum Setting {
	OFF ("---"),
	LOW ("--+"),
	MEDIUM ("-++"),
	HIGH ("+++");

	private String level;

	Setting (String type) {
		level = type;
	}

	public String toString() {
		return level;
	}

}