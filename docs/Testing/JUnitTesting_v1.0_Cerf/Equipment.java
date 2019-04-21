
public class Equipment {
	public static String name;
	public static double size;
	
	public String GetName() {
		return this.name;
	}
	
	public double GetSize() {
		return this.size;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetSize(double size) {
		this.size = size;
	}
	
	public double convert_L_mL(double amount_L) {
		return amount_L * 1000;
	}
}
