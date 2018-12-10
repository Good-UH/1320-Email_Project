/*Defining a base class called Email
 * The class Email will have 3 string member variables:
 * username, domain, and extension
 */

public class Email {

	private String _username;
	private String _domain;
	private String _extension;
	
	Email(String username, String domain, String extension){
	/* this refers to the instance variable.
	Here the precedence is high for the local variable. 
	Therefore the absence of the this denotes the local variable.*/
		this.set_Username(username);
		this.set_Domain(domain);
		this.set_Extension(extension);
		
	}
	//Setters and Getters to access private variables
	public String get_Username() {
		return _username;
	}
	
	public void set_Username(String username) {
		this._username = username;
	}
	
	public String get_Domain() {
		return _domain;
	}
	
	public void set_Domain(String domain) {
		this._domain = domain;
	}
	
	public String get_Extension() {
		return _extension;
	}
	
	public void set_Extension(String extension) {
		this._extension = extension;
	}
	
	public String toString() {
		return this.get_Username() + "@" + this.get_Domain() + "." + this.get_Extension();
	}
}
