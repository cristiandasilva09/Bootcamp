
public class Delete  implements Query{
public Delete() {
	
}
@Override public void consulta() {
	System.out.println("Delete from personas where (id= ?)::consulta method. ");
}

}
