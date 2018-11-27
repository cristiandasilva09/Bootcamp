
public class LandFactory extends TypeOFVehicules {
	@Override
	public Vehicule getVehicule(String type)
	{
		if("car".equals(type))
			return new Car();
		else {
			return new Motorbike();
			}
	}
}
