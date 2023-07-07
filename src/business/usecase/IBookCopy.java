package business.usecase;

import business.model.Book;
import business.exception.BookNotFoundException;

public interface IBookCopy {
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException;
}
