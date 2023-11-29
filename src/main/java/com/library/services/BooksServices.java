package com.library.services;


import com.library.daos.BooksDAO;

import com.library.models.Book;


import java.util.List;

public class BooksServices {

    BooksDAO booksDAO = new BooksDAO();

    public List<Book> getAll() throws Exception {

        if (booksDAO == null){
            throw new Exception("Books is null");
        }

        return booksDAO.getAll();
    }


    public Book getOne(Integer bookId) throws Exception {

        if (bookId == null || bookId == 0){
            throw new Exception("Book not found for ID " + bookId);
        }

        return booksDAO.getOne(bookId);
    }


    public List<Book> getOneTitle(String bookTitle) throws Exception {

        if (bookTitle == null || bookTitle.isEmpty()){
            throw new Exception("Book not found for Title " + bookTitle);
        }

        return booksDAO.getOneTitle(bookTitle);
    }


    public Book create(Book book) throws Exception {

        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            book = booksDAO.create(book);
        } else {
            throw new Exception("Book title cannot be null");
        }
        return book;
    }


    public Book update(Integer bookId, Book updatedBook) throws Exception{

        Book b = booksDAO.getOne(bookId);

        if (b != null) {
            b.setTitle(updatedBook.getTitle());
            return booksDAO.update(bookId, updatedBook);
        } else {
            throw new Exception("Book not found for ID " + bookId);
        }
    }


    public void delete(Integer bookId) throws Exception{

        Book b = booksDAO.getOne(bookId);

        if (b != null) {
            booksDAO.delete(bookId);
        } else {
            throw new Exception("Book not found for ID " + bookId);
        }

    }


}
