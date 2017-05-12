package bg.elsys.ip.rest;

public class Car {

	private int id;
	private String name;
	private String brand;
	private String model;
	private int horsePower;
	private String year;
	
	public Car() {}
	
	public Car(int id, String name, String brand, String model, int horsePower, String year) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
