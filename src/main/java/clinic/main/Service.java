package clinic.main;

public class Service {
	 String name;
	 double price ;

	public Service(String n, double p) {
		setName(n);
		setPrice(p);
	}
	
	public void setPrice(double pricee) {
		price = pricee;
		
	}
	
	public double getPrice() {
		return price;
	}

	
	public void setName(String namee) {
		name = namee;
		
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString()
	{
		return name +"  " +price;
	}

}
