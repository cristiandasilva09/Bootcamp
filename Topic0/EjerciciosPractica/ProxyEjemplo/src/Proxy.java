import java.util.Date;
 class Proxy {
	SlowRunner slowRider;
	public Proxy()
	{
		System.out.println("Creating proxy at" + new Date());
	}
	public void resulst() {
		if (slowRider == null) {
			slowRider = new SlowRunner();
		}
		slowRider.resulst();
	}
}
