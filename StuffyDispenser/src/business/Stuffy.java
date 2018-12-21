package business;

public class Stuffy {
	private int id;
	private String type;
	private String size;
	private String color;
	

	public Stuffy(int id, String type, String size, String color) {
		this.id = id;
		this.type = type;
		this.size = size;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
