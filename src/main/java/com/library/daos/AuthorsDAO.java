package com.library.daos;

import com.library.models.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AuthorsDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_pu");
    EntityManager em = emf.createEntityManager();


    public List<Author> getAll() {

        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        List<Author> list = query.getResultList();

        return list;

    }

    public Author getOne(Integer authorId) {

        TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = :authorIdKey", Author.class);
        query.setParameter("authorIdKey", authorId);
        Author author = query.getSingleResult();

        return author;

    }

    public List<Author> getOneName(String authorName) {

        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :authorNameKey", Author.class);
        query.setParameter("authorNameKey", "%" + authorName + "%");
        List<Author> author = query.getResultList();

        return author;

    }

    public Author create(Author author) {

        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();

        return author;
    }

    public Author update(Integer authorId, Author updatedAuthor) {

        TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = :authorIdKey", Author.class);
        query.setParameter("authorIdKey", authorId);
        Author author = query.getSingleResult();
        if (author != null) {
            author.setName(updatedAuthor.getName());
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
        }

        return author;
    }


    public void delete( Integer authorId) {

        TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = :authorIdKey", Author.class);
        query.setParameter("authorIdKey", authorId);
        Author author = query.getSingleResult();
        if (author != null) {
            em.getTransaction().begin();
            em.remove(author);
            em.getTransaction().commit();
        }

    }
}
