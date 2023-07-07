package business.usecase;

import java.util.List;

import business.model.Book;

public interface IGetBook {
	public List<Book> getBookCollection();
}
