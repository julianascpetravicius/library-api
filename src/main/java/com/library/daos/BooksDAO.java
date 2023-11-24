package com.library.daos;

import com.library.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BooksDAO {
    public List<Book> getAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> list = query.getResultList();

        return list;

    }

    public Book getOne(Integer bookId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.id = :bookIdKey", Book.class);
        query.setParameter("bookIdKey", bookId);
        Book book = query.getSingleResult();

        return book;

    }

    public List<Book> getOneTitle(String bookTitle) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :bookTitleKey", Book.class);
        query.setParameter("bookTitleKey", "%" + bookTitle + "%");
        List<Book> book = query.getResultList();

        return book;

    }

    public Book create(Book book) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

        return book;
    }

    public Book update(Integer bookId, Book updatedBook) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();
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


    public Book delete( Integer bookId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :bookIdKey", Book.class);
        query.setParameter("bookIdKey", bookId);
        Book book = query.getSingleResult();
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }

        return null;
    }
}

