
public class Car {
private String brand;
private String model;
private String year;
private String color;

public Car() {
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
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String toString() {
	return "brand: " + brand + ", model: " + model + ", year: " +  year +  "color: " + color;
}

}
