import java.util.*;

 public class Recipe {
	private String name;
	private Map<String, String> content = new HashMap<String, String>();
	//private String unit;

 	public String GetName() {
		return name;
	}

 	public Map<String, String> GetContent() {
		return content;
	}

 	public void SetName(String name) {
		this.name = name;
	}

 	public void SetContent(Map<String, String> content) {
		this.content = content;
	}
}