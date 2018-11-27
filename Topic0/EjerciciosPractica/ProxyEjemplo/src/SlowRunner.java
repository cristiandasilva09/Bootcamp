
public class SlowRunner extends Race {
	public SlowRunner()
	{
		try {
			Thread.sleep(20000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
