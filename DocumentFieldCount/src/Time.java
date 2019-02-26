
public class Time {
	private int id;
	private int hours;
	private int minutes;
	private int seconds;
	
	public Time(int id, int hours, int minutes, int seconds) {
		super();
		this.id = id;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
