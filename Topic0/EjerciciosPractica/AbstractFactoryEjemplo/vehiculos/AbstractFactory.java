
public class AbstractFactory {
	public TypeOFVehicules getTypeOFVehicules(String type) {
		if ("land".equals(type)) {
			return new LandFactory();
		} else {
			return new AirFactory();
		}
	}
}
