import java.text.SimpleDateFormat;

public class Note {
	private String content;
	private String date;

	public Note(String content) {
		this.content = content;
		double timeStamp = System.currentTimeMillis();
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	    this.date = format.format(timeStamp);
	}
	
	public String GetContent() {
		return this.content;
	}
	
	public String GetTime() {
		return this.date;
	}
	
	public void SetContent(String content) {
		this.content = content;
	}
	
	
}
