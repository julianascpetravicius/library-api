package com.library.services;

import com.library.daos.AuthorsDAO;
import com.library.models.Author;

import java.util.List;

public class AuthorsService {

    public List<Author> getAllAuthors() {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getAll();
    }


    public Author getAuthorById(Integer authorId) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getOne(authorId);
    }


    public List<Author> getAuthorsByName(String authorName) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getOneName(authorName);
    }


    public Author createAuthor(Author author) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        if(author.getName() == null || author.getName().isEmpty()){
            author = authorsDAO.create(author);
        }
        return author;
    }


    public Author updateAuthor(Integer authorId, Author updatedAuthor) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
       Author a = authorsDAO.getOne(authorId);

       if (a != null){
           a.setName(updatedAuthor.getName());
           return authorsDAO.update(authorId, updatedAuthor);
       }
       return a;
    }


    public Author deleteAuthor(Integer authorId) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        Author a = authorsDAO.getOne(authorId);

        if (a != null){
            authorsDAO.delete(authorId);
        }
      return null;
    }

}
