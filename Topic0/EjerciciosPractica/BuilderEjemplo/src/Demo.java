
public class Demo {

	public static void main(String[] args) {
		CarBuilder carBuilder = new BMWBuilder();
		CarDirector carDirector = new CarDirector(carBuilder);
		carDirector.constructCar();
		Car car1 =carDirector.getCar();
		System.out.println("car is:" +car1);

		 carBuilder = new ToyotaBuilder();
		carDirector = new CarDirector(carBuilder);
		carDirector.constructCar();
		Car car2 =carDirector.getCar();
		System.out.println("car is:" +car2);
		
		
		

	}

}
