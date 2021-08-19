package pojo;

public class BankAccount {
	// | id | name | type | bal  |
	// | int| string|string|double
	
	private int id;
	private String name,type;
	private double bal;
	
	public BankAccount() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", type=" + type + ", bal=" + bal + "]";
	}	
}
