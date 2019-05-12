import java.text.SimpleDateFormat;
import java.util.Map;

public class Brewing {
	
	private String date;
	private double batchSize;
	private Note note;
	private Recipe recipe;
	
	public Brewing(double batchSize, Recipe recipe) {
		double timeStamp = System.currentTimeMillis();
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	    this.date = format.format(timeStamp);
	    this.batchSize = batchSize;
	    this.note = new Note("");
	    this.recipe = recipe;
	}
	
	public String GetDate() {
		return this.date;
	}
	
	public double GetBatchSize() {
		return this.batchSize;
	}
	
	public Note GetNote() {
		return this.note;
	}
	
	public void implement() {
		Map<String,Double> converedIngredientList = recipe.convertValue(batchSize);
		
	}
}
