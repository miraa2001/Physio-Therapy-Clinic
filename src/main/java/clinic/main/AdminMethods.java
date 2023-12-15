package clinic.main;

import java.util.ArrayList;
import java.util.List;

public class AdminMethods {
	private static List<Admin> admins=new ArrayList<>();
	private static List<Service> services=new ArrayList<>();
	public static void initServices()
	{
		if(services.size()<4)
		{
			Service s1=new Service("Massage Therapy",200);
			Service s2=new Service("Sports Injuries",120);
			Service s3=new Service("Custom Orthotics",300);
			Service s4=new Service("Acupuncture",200);
			services.add(s1);
			services.add(s2);
			services.add(s3);
			services.add(s4);
		}
	}
	public static Boolean checkIfServiceCanBeAdded(Service s)
	{
		for (int i=0 ; i <AdminMethods.services.size() ; i++ )
		{
			if(services.get(i).getName().equalsIgnoreCase(s.getName()))
			{
				return true;
			}
		}
		return false;
	}
	public static void addService(Service s) 
	{
		services.add(s);
	}
	public static int search(String u)
	{
		for(int i=0;i<admins.size();i++)
		{
			if(u.equals(admins.get(i).getUsername()))
				return i;
		}
		return -1;
	}
	public static List<Service> getServices() {
		return services;
	}
	public static List<Admin> getAdmins() {
		return admins;
	}
}
