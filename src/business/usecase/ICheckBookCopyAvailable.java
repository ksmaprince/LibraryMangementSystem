package business.usecase;

import business.model.Book;

public interface ICheckBookCopyAvailable {
	public Book checkBookAvailableCopy(String bookId);
}
