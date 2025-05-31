package Pack3;

class Ex11Book {
	private String title;
	private String author;
	
	public Ex11Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getBookInfo( ) {
		return title + ", 저자는 " + author;
	}
	
}
