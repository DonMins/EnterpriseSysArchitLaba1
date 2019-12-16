package com.laba1.Dao;

import com.laba1.Entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


@Stateless(name = "UserDaoImpl")
public class UserDaoImpl implements UserDao {

    private EntityManager em = Persistence.createEntityManagerFactory("hibernate.ejb.entitymanager_factory_name").createEntityManager();

    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByLogin(String login) {
        List<User> user = em.createQuery("select a from User a where a.login =:login")
                .setParameter("login", login)
                .getResultList();
        if (user.size() == 0) {
            return null;
        }
        return user.get(0);
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.getTransaction().commit();
    }

    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.flush();
        em.getTransaction().commit();
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.flush();
        em.getTransaction().commit();
    }

    public List<User> findAll() {

        return em.createQuery("select a from User a", User.class).getResultList();
    }
}