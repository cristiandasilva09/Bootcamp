
public class AirFactory  extends TypeOFVehicules{
@Override
	public Vehicule getVehicule(String type)
	{
		if("plane".equals(type))
			return new Plane();
		else {
			return new Helicopter();
			}
	}
}
