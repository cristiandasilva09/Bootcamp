
public class Demo {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = new AbstractFactory();

		TypeOFVehicules typeFactory1 = abstractFactory.getTypeOFVehicules("land");
		Vehicule v1 = typeFactory1.getVehicule("car");
		System.out.println("The vehicule1 is: " + v1.getVehicule());
		Vehicule v2 = typeFactory1.getVehicule("motorbike");
		System.out.println("The vehicule2 is: " + v2.getVehicule());

		TypeOFVehicules typeFactory2 = abstractFactory.getTypeOFVehicules("air");
		Vehicule v3 = typeFactory2.getVehicule("plane");
		System.out.println("The vehicule3 is: " + v3.getVehicule());
		Vehicule v4 = typeFactory2.getVehicule("helicopter");
		System.out.println("The vehicule4 is: " + v4.getVehicule());


	}

}
