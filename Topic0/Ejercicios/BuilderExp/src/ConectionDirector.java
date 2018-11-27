
public class ConectionDirector {
  private ConectionBuilder conBuilder=null;
  
  public ConectionDirector(ConectionBuilder conbuilder) {
	  this.conBuilder=conbuilder;
  }
  public void constructCon() {
	  conBuilder.buildUrl();
	  conBuilder.buildUsr();
	  conBuilder.buildPas();
  }
  public Conection getCon() {
	  return conBuilder.getConection();
  }
}
