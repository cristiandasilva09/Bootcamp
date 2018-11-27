
public class ToyotaBuilder  implements CarBuilder{
	private Car car;
	public ToyotaBuilder() {
		car = new Car();
	}
	@Override
	public void buildBrand()
	{
		car.setBrand("Toyota");
	}
	@Override
	public void buildModel()
	{
		car.setModel("Supra MKIV");
	}
	@Override
	public void buildYear()
	{
		car.setYear("1994");
	}
	@Override
	public void buildColor()
	{
		car.setColor("red");
	}
	@Override
	public Car getCar()
	{
		return car;
	}
}
