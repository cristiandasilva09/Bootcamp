
public class Demo {
	public static void main(String[] args) 
	{
	ConectionBuilder conBuilder = new MysqlBuilder();
	ConectionDirector conDirector = new ConectionDirector(conBuilder);
	conDirector.constructCon();
	Conection con=conDirector.getCon();
	System.out.println("con es: " + con);
	
	 conBuilder = new PostgreBuilder();
	 conDirector = new ConectionDirector(conBuilder);
	conDirector.constructCon();
	 con=conDirector.getCon();
	System.out.println("con es: " + con);
	
	}
}
