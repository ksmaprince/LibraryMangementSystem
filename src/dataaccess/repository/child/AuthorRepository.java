package dataaccess.repository.child;

import business.model.Author;
import dataaccess.DataAccess;
import dataaccess.repository.BaseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthorRepository extends BaseRepository {
    public AuthorRepository(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Author> getAllAuthors() {
        HashMap<String, Author> authors = dataAccess.readAuthorMap();
        if (authors == null)
            return null;
        return new ArrayList<>(authors.values());
    }
}
