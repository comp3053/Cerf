import java.util.Date;

public class Note {
	private String content;
	private Date date;

	Note(String content) {
		this.content = content;
		//TimeStamp timeStamp = new TimeStamp(System.currentTimeMillis());
		//SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
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
