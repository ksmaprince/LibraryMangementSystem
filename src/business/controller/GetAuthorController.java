package business.controller;

import java.util.List;

import business.usecase.IGetAuthor;
import dataaccess.DataAccessFacade;
import business.model.Author;
import dataaccess.repository.child.AuthorRepository;

public class GetAuthorController extends BaseController implements IGetAuthor {
	GetAuthorController() {
	}
	@Override
	public List<Author> getAllAuthors() {
		AuthorRepository repo = new AuthorRepository(new DataAccessFacade());
		return repo.getAllAuthors();
	}
}
