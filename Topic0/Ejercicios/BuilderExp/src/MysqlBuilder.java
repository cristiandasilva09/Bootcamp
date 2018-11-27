
public class MysqlBuilder implements ConectionBuilder{

private Conection con;

public MysqlBuilder() {
	con = new Conection();
}

@Override
public void buildUrl() {
	con.setUrl("jdbc:mysql://localhost/java_mysql");;
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
