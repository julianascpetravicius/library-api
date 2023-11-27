package com.library.services;

import com.library.daos.AuthorsDAO;
import com.library.models.Author;

import java.util.List;

public class AuthorsService {

    public List<Author> getAll() {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getAll();
    }


    public Author getOne(Integer authorId) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getOne(authorId);
    }


    public List<Author> getOneName(String authorName) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        return authorsDAO.getOneName(authorName);
    }


    public Author create(Author author) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        if(author.getName() == null || author.getName().isEmpty()){
            author = authorsDAO.create(author);
        }
        return author;
    }


    public Author update(Integer authorId, Author updatedAuthor) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
       Author a = authorsDAO.getOne(authorId);

       if (a != null){
           a.setName(updatedAuthor.getName());
           return authorsDAO.update(authorId, updatedAuthor);
       }
       return a;
    }


    public Author delete(Integer authorId) {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        Author a = authorsDAO.getOne(authorId);

        if (a != null){
            authorsDAO.delete(authorId);
        }
      return null;
    }

}
