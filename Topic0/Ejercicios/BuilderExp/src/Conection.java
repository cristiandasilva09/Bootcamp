
public class Conection {
	private String url;
	private String usr;
	private String psw;
	
	public Conection() {
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getUSr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String toString() {
		return "url:" + url + ", usr:" + usr + ", psw:" + psw;
	}
}
