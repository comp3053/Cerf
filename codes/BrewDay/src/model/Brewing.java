package model;

import java.util.Date;

public class Brewing {
    private Date date;
    private double batchSize;
    private Note note;
    private Recipe recipe;

    public Brewing(double batchSize, Recipe recipe, Date date) {
        this.date = date;
        this.batchSize = batchSize;
        this.note = new Note("","", date);
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

    }
}
