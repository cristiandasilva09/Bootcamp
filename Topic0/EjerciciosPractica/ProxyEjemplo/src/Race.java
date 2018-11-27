import java.util.Date;
public abstract class Race {
	public void resulst()
	{
		System.out.println(this.getClass().getSimpleName()+"finish the race at "+ new Date ());
	}
}
