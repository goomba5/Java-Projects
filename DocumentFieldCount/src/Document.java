
public class Document {
	private int id;
	private int fields;
	private int time;
	private String name;
	
	public Document(int id, int fields, int time, String name) {
		super();
		this.id = id;
		this.fields = fields;
		this.time = time;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFields() {
		return fields;
	}

	public void setFields(int fields) {
		this.fields = fields;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", fields=" + fields + ", name=" + name + "]";
	}
	
}
