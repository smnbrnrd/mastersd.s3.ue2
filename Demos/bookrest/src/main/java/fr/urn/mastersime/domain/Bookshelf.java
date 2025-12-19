package fr.urn.mastersime.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bookshelf {

	private List<Book> books = new ArrayList<Book>();
	
	public Bookshelf() {
		this.populate();
	}
	
	public boolean add(Book book) throws InvalidBookException {
		book.validate();
		for(Book b : this.books) {
			if(book.getTitle().equals(b.getTitle())) {
				throw new InvalidBookException("Bookshelf already contains a review for a book titled " + book.getTitle());
			}
		}
		this.books.add(book);
		return true;
	}

	public Book get(int idx) throws InvalidBookException {
		try {
			return this.books.get(idx);
		} catch(IndexOutOfBoundsException ex) {
			throw new InvalidBookException("Wrong book ID", ex);
		}
	}

	public boolean delete(String title) {
		Iterator<Book> itr = this.books.iterator();
		while (itr.hasNext()) {
			Book book = (Book) itr.next();
			if(book.getTitle().equals(title)) {
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	public List<Book> getBooksByAuthor(String author) {
		List<Book> bookList = new ArrayList<>();
		for(Book book : this.books) {
			if(book.getAuthor().equals(author)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	public List<Book> getBooksByTitle(String title) {
		List<Book> bookList = new ArrayList<>();
		for(Book book : this.books) {
			if(book.getTitle().equals(title)) {
				bookList.add(book);
			}
		}
		return bookList;
	}
	
	public List<Book> getAllBooks() {
		return this.books;
	}
	
	private void populate() {
		this.books.add(new Book("La horde du contrevent", "Alain Damasio","One of the best science fantasy book I've ever read", 4.45));
		this.books.add(new Book("Letter to Menoeceus", "Epicurus", "How about some philosophical material?", 3.81));
		this.books.add(new Book("The Shining", "Stephen King","", 4.26));
		this.books.add(new Book("It", "Stephen King","", 4.25));
		this.books.add(new Book("Carrie", "Stephen King","", 3.98));
		this.books.add(new Book("Solar Lottery", "Philip K. Dick", "The first book of PKD et one of the best", 3.5));
		this.books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", "A must for anyone who loves science fiction", 4.09));
		this.books.add(new Book("The Man in the High Castle", "Philip K. Dick", "This one's a classic of alternative history scifi", 3.61));
		this.books.add(new Book("Maus", "Art Spiegelman", "one hell of a comic book", 4.56));
		this.books.add(new Book("Madame Bovary", "Gustave Flaubert", "", 3.69));
		this.books.add(new Book("Confessions", "Jean-Jacques Rousseau", "Boriiiiiiiing", 3.59));		
		this.books.add(new Book("The Hobbit", "J.R.R. Tolkien","This is a classic. To be read first.", 4.28));
		this.books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien","The door to another dimension", 4.38));
		this.books.add(new Book("The Two Towers", "J.R.R. Tolkien","The epic journey continue", 4.47));
		this.books.add(new Book("The Return of the King", "J.R.R. Tolkien","Last but not least", 4.55));
		this.books.add(new Book("Antigone", "Sophocles","", 3.67));
		this.books.add(new Book("And then there were none", "Agatha Christie","This book is always a treat", 4.28));
		this.books.add(new Book("Charlie and the Chocolate Factory", "Roald Dahl","A little return to childhood that always feels good", 4.15));
        this.books.add(new Book("The da Vinci Code","Dan Brown","A new breed of lightning-paced intelligent thriller",3.92));
        this.books.add(new Book("Gödel Escher Bach: An Eternal Golden Braid","Douglas R. Hofstadter","wonderful exploration of fascinating ideas at the heart of cognitive science",4.29));
        this.books.add(new Book("War and peace","Leo Tolstoy","Oh dear god why?!",4.16));
        this.books.add(new Book("The call of the wild","Jack London","",3.91));
        this.books.add(new Book("Les misérables","Victor Hugo","Long but beautiful",4.21));
        this.books.add(new Book("The Count of Monte Cristo","Alexandre Dumas","An epic tale of an innocent man betrayed",4.28));
        this.books.add(new Book("1984","George Orwell","Terrifying brutal intricate prophetic GENIUS!",4.19));
		this.books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "", 4.47));
		this.books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "", 4.43));
		this.books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "", 4.58));
		this.books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "", 4.57));
		this.books.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "", 4.50));
		this.books.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "", 4.58));
		this.books.add(new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", "", 4.62));
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : this.books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}
