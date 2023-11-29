package com.library.resources;


import com.library.models.Author;
import com.library.services.AuthorsService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/authors")
public class AuthorResource {

    AuthorsService authorsService = new AuthorsService();

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    public List<Author> getAll() throws Exception {

        List<Author> authors = authorsService.getAll();

        return authors;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/{authorId}")
    public Author getOne(@PathParam("authorId") Integer authorId) throws Exception {

        Author author = authorsService.getOne(authorId);

        return author;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/name")//troquei o nome do caminho porque havia conflito
    public List<Author> getOneName(@QueryParam("authorName") String authorName) throws Exception {

        List<Author> authors = authorsService.getOneName(authorName);

        return authors;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    public Author create(Author author) throws Exception {

        Author authors = authorsService.create(author);

        return authors;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{authorId}")
    public Author update(@PathParam("authorId") Integer authorId, Author updatedAuthor) throws Exception {

        Author authors = authorsService.update(authorId, updatedAuthor);

        return authors;
    }


    @Produces(value = MediaType.APPLICATION_JSON)
    @DELETE
    @Path("/{authorId}")
    public void delete(@PathParam("authorId") Integer authorId) throws Exception {


        authorsService.delete(authorId);

    }
}

