package com.library.services;


import com.library.daos.BooksDAO;

import com.library.models.Book;


import java.util.List;

public class BooksServices {


    public List<Book> getAll() {
        BooksDAO booksDAO = new BooksDAO();
        return booksDAO.getAll();
    }


    public Book getOne(Integer bookId) {
        BooksDAO booksDAO = new BooksDAO();
        return booksDAO.getOne(bookId);
    }


    public List<Book> getOneName(String bookTitle) {
        BooksDAO booksDAO = new BooksDAO();
        return booksDAO.getOneTitle(bookTitle);
    }


    public Book create(Book book) {
        BooksDAO booksDAO = new BooksDAO();

        if(book.getTitle() == null || book.getTitle().isEmpty()){
            book = booksDAO.create(book);
        }
        return book;
    }


    public Book update(Integer bookId, Book updatedBook) {
        BooksDAO booksDAO = new BooksDAO();
        Book b = booksDAO.getOne(bookId);

        if (b != null){
            b.setTitle(updatedBook.getTitle());
            return booksDAO.update(bookId, updatedBook);
        }
        return b;
    }


    public Book delete(Integer bookId) {
        BooksDAO booksDAO = new BooksDAO();
        Book b = booksDAO.getOne(bookId);

        if (b != null){
            booksDAO.delete(bookId);
        }
        return null;
    }


}
