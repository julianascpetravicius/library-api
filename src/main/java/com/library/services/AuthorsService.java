package com.library.services;

import com.library.daos.AuthorsDAO;
import com.library.models.Author;

import java.util.List;

public class AuthorsService {

    AuthorsDAO authorsDAO = new AuthorsDAO();

    public List<Author> getAll() throws Exception {
        if (authorsDAO == null) {
            throw new Exception("Authors is null");
        }

        return authorsDAO.getAll();
    }


    public Author getOne(Integer authorId) throws Exception {
        if (authorId == null || authorId == 0){
            throw new Exception("Authors Id cannot is valid");
        }

        return authorsDAO.getOne(authorId);
    }


    public List<Author> getOneName(String authorName) throws Exception {
        if (authorName == null || authorName.isEmpty()){
            throw new Exception("AuthorName is not valid");
        }

        return authorsDAO.getOneName(authorName);
    }


    public Author create(Author author) throws Exception {

        if(author.getName() != null ){
            author = authorsDAO.create(author);
        } else {
            throw new Exception("Author name cannot be null");
        }
        return author;
    }


    public Author update(Integer authorId, Author updatedAuthor) throws Exception {

       Author a = authorsDAO.getOne(authorId);

       if (a != null){
           a.setName(updatedAuthor.getName());
           return authorsDAO.update(authorId, updatedAuthor);
       } else {
           throw new Exception("Author not found for ID " + authorId);
       }
    }


    public void delete(Integer authorId) throws Exception {

        Author a = authorsDAO.getOne(authorId);

        if (a != null){
            authorsDAO.delete(authorId);
        } else {
            throw new Exception("Author ID cannot be null");
        }

    }

}
