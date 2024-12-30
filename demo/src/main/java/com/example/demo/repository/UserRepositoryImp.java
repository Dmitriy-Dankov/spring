package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User all", User.class).getResultList();
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        em.remove(getUser(id));
    }

    @Transactional
    @Override
    public void updateUser(User newUser) {
        em.merge(newUser);
    }
}
