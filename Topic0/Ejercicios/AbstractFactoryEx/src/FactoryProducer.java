
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
		   
	      if(choice.equalsIgnoreCase("BD")){
	         return new BDFactory();
	         
	      }else if(choice.equalsIgnoreCase("QUERY")){
	         return new QueryFactory();
	      }
	      
	      return null;
	   }
}
