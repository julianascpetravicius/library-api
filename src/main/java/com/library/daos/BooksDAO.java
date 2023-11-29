package com.library.daos;

import com.library.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BooksDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
    EntityManager em = emf.createEntityManager();

    public List<Book> getAll() {

        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        List<Book> list = query.getResultList();

        return list;

    }

    public Book getOne(Integer bookId) {

        TypedQuery<Book> query = em.createQuery("select b from Book b where b.id = :bookIdKey", Book.class);
        query.setParameter("bookIdKey", bookId);
        Book book = query.getSingleResult();

        return book;

    }

    public List<Book> getOneTitle(String bookTitle) {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :bookTitleKey", Book.class);
        query.setParameter("bookTitleKey", "%" + bookTitle + "%");
        List<Book> book = query.getResultList();

        return book;

    }

    public Book create(Book book) {

        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

        return book;
    }

    public Book update(Integer bookId, Book updatedBook) {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :bookIdKey", Book.class);
        query.setParameter("bookIdKey", bookId);
         Book book = query.getSingleResult();
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        }

        return book;
    }


    public void delete( Integer bookId) {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :bookIdKey", Book.class);
        query.setParameter("bookIdKey", bookId);
        Book book = query.getSingleResult();
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }

    }
}

