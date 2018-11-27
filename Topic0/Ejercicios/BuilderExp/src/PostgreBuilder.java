
public class PostgreBuilder implements ConectionBuilder {
	private Conection con;

	public PostgreBuilder() {
		con = new Conection();
	}

	@Override
	public void buildUrl() {
		con.setUrl("jdbc:postgresql://hostname:port/dbname");;
	}

	@Override
	public void buildUsr() {
		con.setUsr("root");
	}

	@Override
	public void buildPas() {
		con.setPsw("");
	}

	@Override
	public Conection getConection() {
		return con;
	}
}
