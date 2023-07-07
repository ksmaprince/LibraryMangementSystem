package business.usecase;

import java.util.List;

import business.model.Book;

public interface ISearchBook {
	public Book searchBook(String isbn);

	public List<Book> getBookCollection();
}
