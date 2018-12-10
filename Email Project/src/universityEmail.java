//Inherit the Email class by using extends
public class universityEmail extends Email {

	private String _subdomain;
	private int _code;
	
	universityEmail(String username, String domain, String extension, String subdomain){
		super(username, domain, extension); //calls the parent constructor with 3 arguments
		this.set_subdomain(subdomain);
		
		if (this.get_subdomain().equals("art")) {
			this.set_code(1);
		}
		else if (this.get_subdomain().equals("chee")) {
			this.set_code(2);
		}
		else if (this.get_subdomain().equals("chem")) {
			this.set_code(3);
		}
		else if (this.get_subdomain().equals("coe")) {
			this.set_code(4);
		}
		else if (this.get_subdomain().equals("cs")) {
			this.set_code(5);
		}
		else if (this.get_subdomain().equals("egr")) {
			this.set_code(6);
		}
		else if (this.get_subdomain().equals("polsci")) {
			this.set_code(7);
		}
		else {
			this.set_code(-1);
		}
	}
	
	public void set_subdomain(String subdomain) {
		this._subdomain = subdomain;
	}
	
	public String get_subdomain() {
		return _subdomain;
	}
	
	public void set_code(int code) {
		this._code = code;
	}
	
	public int get_code() {
		return _code;
	}
	
	public String toString() {
		return this.get_Username() + "@" + this.get_subdomain() + "." + this.get_Domain() + "." + this.get_Extension();
	}
}
