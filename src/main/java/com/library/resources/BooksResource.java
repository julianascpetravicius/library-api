package com.library.resources;


import com.library.daos.BooksDAO;

import com.library.models.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/book")
public class BooksResource {

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    public List<Book> getAll() {
        BooksDAO booksDAO = new BooksDAO();

        List<Book> books = booksDAO.getAll();

        return books;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/{bookId}")
    public Book getOne(@PathParam("bookId") Integer bookId) {
        BooksDAO booksDAO = new BooksDAO();

        Book book = booksDAO.getOne(bookId);

        return book;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/title")/*troquei o nome do caminho porque estava tendo conflito*/
    public List<Book> getOneTitle(@QueryParam("bookTitle") String bookTitle) {
        BooksDAO booksDAO = new BooksDAO();

        List<Book> books = booksDAO.getOneTitle(bookTitle);

        return books;

    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    public Book create(Book book) {
        BooksDAO booksDAO = new BooksDAO();

        Book books = booksDAO.create(book);

        return books;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{bookId}")
    public Book update(@PathParam("bookId") Integer bookId, Book updatedBook) {
        BooksDAO booksDAO = new BooksDAO();

        Book book = booksDAO.update(bookId, updatedBook);

        return book;
    }


    @Produces(value = MediaType.APPLICATION_JSON)
    @DELETE
    @Path("/{bookId}")
    public void delete(@PathParam("bookId") Integer bookId) {

        BooksDAO booksDAO = new BooksDAO();

        Book book = booksDAO.delete(bookId);

    }
}
