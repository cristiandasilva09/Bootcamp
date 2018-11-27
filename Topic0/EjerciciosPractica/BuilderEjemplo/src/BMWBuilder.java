
public class BMWBuilder  implements CarBuilder{
	private Car car;
	public BMWBuilder() {
		car = new Car();
	}
	@Override
	public void buildBrand()
	{
		car.setBrand("BMW");
	}
	@Override
	public void buildModel()
	{
		car.setModel("i3");
	}
	@Override
	public void buildYear()
	{
		car.setYear("2014");
	}
	@Override
	public void buildColor()
	{
		car.setColor("blue");
	}
	@Override
	public Car getCar()
	{
		return car;
	}
}
