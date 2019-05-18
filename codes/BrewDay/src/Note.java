import java.util.Date;

public class Note {
	private String content;
	private Date date;

	Note(String content) {
		this.content = content;
	    this.date = new Date();
	}
	
	public String GetContent() {
		return this.content;
	}
	
	public Date GetTime() {
		return this.date;
	}
	
	public void SetContent(String content) {
		this.content = content;
	}
	
	
}
