
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		 AbstractFactory BDFactory = FactoryProducer.getFactory("BD");
		 BD bd1 =BDFactory.getBD("Mysql");
		 bd1.conectar();
		
		 BD bd2 =BDFactory.getBD("Postgresql");
		 bd2.conectar();
		 
		 AbstractFactory QueryFactory = FactoryProducer.getFactory("Query");
		 Query query1=QueryFactory.getQuery("INSERT");
		 query1.consulta();
		 
		 Query query2=QueryFactory.getQuery("DELETE");
		 query2.consulta();
		 
	}
}
