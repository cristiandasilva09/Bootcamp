
public class Singleton {
	private static Singleton singletonEj = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singletonEj == null) {
			singletonEj = new Singleton();
		}
		return singletonEj;
	}

	public void sayHello() {
		System.out.println("Hello");
		System.out.println("This is an example of a Singleton class");
	}
}

