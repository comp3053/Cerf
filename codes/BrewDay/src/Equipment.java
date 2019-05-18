public class Equipment {
	private String name;
	private double size;
	
	public Equipment(String name, double size) {
		this.name = name;
		this.size = size;
	}
	
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
}
