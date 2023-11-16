package com.library.resources;


import com.library.models.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;



@Path("/books")
public class BooksResource {

    static Book[] books = new Book[10];

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    public Book[] getAll() {
        return books;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("/{bookId}")
    public Book getOne(@PathParam("bookId") Integer bookId) {

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {

                Book b = books[i];
                if (b.getId().equals(bookId)) {
                    return b;
                }
            }

        }
        return null;
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    public Book create(Book book) {

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;

                return book;
            }
        }

        return book;
    }


    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{bookId}")
    public Book update(@PathParam("bookId") Integer bookId, Book updatedBook) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (books[i] != null && b.getId().equals(bookId)) {
                b.setTitle(updatedBook.getTitle());

                return b;
            }
        }

        return null;
    }


    @DELETE
    @Path("/{bookId}")
    public String delete(@PathParam("bookId") Integer bookId) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (books[i] != null && b.getId().equals(bookId)){

                books[i] = null;

                return null;
            }
        }
        return null;
    }

}
