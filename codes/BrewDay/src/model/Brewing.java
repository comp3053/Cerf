package model;

import java.util.Date;

class Brewing {
    private final Date date;
    private final double batchSize;
    private final Note note;

    public Brewing(double batchSize, Recipe recipe, Date date) {
        this.date = date;
        this.batchSize = batchSize;
        this.note = new Note("", "", date);
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
}
