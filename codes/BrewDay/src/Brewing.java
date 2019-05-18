import java.util.Date;
import java.util.Map;

public class Brewing {
    private Date date;
    private double batchSize;
    private Note note;
    private Recipe recipe;

    public Brewing(double batchSize, Recipe recipe) {
        this.date = new Date();
        this.batchSize = batchSize;
        this.note = new Note("");
        this.recipe = recipe;
    }

    public Date GetDate() {
        return this.date;
    }

    public double GetBatchSize() {
        return this.batchSize;
    }

    public Note GetNote() {
        return this.note;
    }

    public void implement() {
        Map<String, Double> converedIngredientList = recipe.convertValue(batchSize);

    }
}
