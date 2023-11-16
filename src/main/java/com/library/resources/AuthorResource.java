package com.library.resources;

import com.library.daos.AuthorsDAO;
import com.library.models.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/authors")
public class AuthorResource {

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    public List<Author> getAll() {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        List<Author> authors = authorsDAO.getAll();

        return authors;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/{authorId}")
    public Author getOne(@PathParam("authorId") Integer authorId) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        Author author = authorsDAO.getOne(authorId);

        return author;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/name")/*troquei o nome do caminho porque estava tendo conflito*/
    public List<Author> getOneName(@QueryParam("authorName") String authorName) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        List<Author> authors = authorsDAO.getOneName(authorName);

        return authors;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    public Author create(Author author) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        Author authors = authorsDAO.create(author);

        return authors;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{authorId}")
    public Author update(@PathParam("authorId") Integer authorId, Author updatedAuthor) {
        AuthorsDAO authorsDAO = new AuthorsDAO();

        Author authors = authorsDAO.update(authorId, updatedAuthor);

        return authors;
    }


    @Produces(value = MediaType.APPLICATION_JSON)
    @DELETE
    @Path("/{authorId}")
    public void delete(@PathParam("authorId") Integer authorId, Author updatedAuthor) {

        AuthorsDAO authorsDAO = new AuthorsDAO();

        Author authors = authorsDAO.delete(authorId, updatedAuthor);

    }
}

