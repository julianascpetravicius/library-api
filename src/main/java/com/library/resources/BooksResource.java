package com.library.resources;


import com.library.models.Book;
import com.library.services.BooksServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/book")
public class BooksResource {

    BooksServices booksServices = new BooksServices();

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    public List<Book> getAll() throws Exception {

        List<Book> books = booksServices.getAll();

        return books;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/{bookId}")
    public Book getOne(@PathParam("bookId") Integer bookId) throws Exception {


        Book book = booksServices.getOne(bookId);

        return book;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/title")
    public List<Book> getOneTitle(@QueryParam("bookTitle") String bookTitle) throws Exception {

        List<Book> books = booksServices.getOneTitle(bookTitle);

        return books;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    public Book create(Book book) throws Exception {

        Book books = booksServices.create(book);

        return books;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{bookId}")
    public Book update(@PathParam("bookId") Integer bookId, Book updatedBook) throws Exception {

        Book book = booksServices.update(bookId, updatedBook);

        return book;
    }


    @Produces(value = MediaType.APPLICATION_JSON)
    @DELETE
    @Path("/{bookId}")
    public void delete(@PathParam("bookId") Integer bookId) throws Exception {

       booksServices.delete(bookId);

    }
}
