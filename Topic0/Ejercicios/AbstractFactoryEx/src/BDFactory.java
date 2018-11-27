
public class BDFactory extends AbstractFactory {
@Override
public BD getBD(String bd) {
	if(bd==null) {
		return null;
	}
	if(bd.equalsIgnoreCase("MYSQL")) {
		return new Mysql();
	}
	if(bd.equalsIgnoreCase("PostgreSql")) {
		return new PostgreSql();
	}
	return null;
}	
@Override
Query getQuery(String query) {
	return null;
}

}
