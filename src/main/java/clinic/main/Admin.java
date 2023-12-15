package clinic.main;

public class Admin extends User{
	public Admin(String s1,String s2,String s3)
	{
		super(s1,s2,s3);
	}
	@Override
	public String toString()
	{
		return super.getName();
	}
	public void setLogState(Boolean logStat) {
	}

}
