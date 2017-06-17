package Cbyd_life;

public class User {
	public static enum Gender{MALE,FEMALE,NONE};
	private String username;
	private Gender gender;
	private boolean existence;
	private boolean hasRecords;
	
	
	public User() {
	}
	
	public User(String username, Gender gender, boolean existence,
			boolean hasRecords) {
		super();
		this.username = username;
		this.gender = gender;
		this.existence = existence;
		this.hasRecords = hasRecords;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isExistence() {
		return existence;
	}
	public void setExistence(boolean existence) {
		this.existence = existence;
	}
	public boolean isHasRecords() {
		return hasRecords;
	}
	public void setHasRecords(boolean hasRecords) {
		this.hasRecords = hasRecords;
	}
	
}
