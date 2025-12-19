package fr.urn.mastersime.domain;

public class Book {

	private String title;
	private String author;
	private String review;
	private double rate;
	
	public Book() {}
	
	public Book(String title, String author, String review, double rate) {
		this.title = title;
		this.author = author;
		this.review = review;
		this.rate = rate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void validate() throws InvalidBookException {
		if (this.title.isEmpty()) {
			throw new InvalidBookException("Book title cannot be empty!");
		}
		if (this.author.isEmpty()) {
			throw new InvalidBookException("Book author cannot be empty!");
		}
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", review=" + review + ", rate=" + rate + "]";
	}
	
	
}
