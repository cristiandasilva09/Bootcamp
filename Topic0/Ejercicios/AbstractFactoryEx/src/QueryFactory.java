
public class QueryFactory extends AbstractFactory {
	@Override
	Query getQuery(String query) {
		if(query ==null) 
		{
		return null;
		}
		if(query.equalsIgnoreCase("INSERT")) {
			return new Insert();
		}
		if(query.equalsIgnoreCase("Delete")) {
			return new Delete();
		}
		return null;
	}
@Override
public BD getBD(String bd)
{
return null;	
}
}