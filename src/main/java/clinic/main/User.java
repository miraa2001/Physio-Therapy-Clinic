package clinic.main;

public abstract class User {
	private String username;
	private String password;
	private String name;
	User(String u,String pass,String n)
	{
		setName(n);
		setPassword(pass);
		setUsername(u);
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}
	public void setPassword(String setPassword)
	{
		password=setPassword;
	}
	public void setName(String setName)
	{
		name=setName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
