
public class CarDirector {
 private CarBuilder carBuilder = null;
 
 public CarDirector(CarBuilder carBuilder)
 {
	 this.carBuilder=carBuilder;
 }
 public void constructCar() 
 {
	carBuilder.buildBrand();
	carBuilder.buildModel();
	carBuilder.buildYear();
	carBuilder.buildColor();
 }
 public Car getCar()
 {
	 return carBuilder.getCar();
 }
}
