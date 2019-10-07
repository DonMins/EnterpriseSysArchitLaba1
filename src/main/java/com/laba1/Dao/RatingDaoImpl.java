package com.laba1.Dao;


import com.laba1.Entity.Rating;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Класс реализующий интерфейс для работы с таблицей Rating
 * @author Maks
 * @version 1.1
 */

@Stateless(name = "RatingDaoImpl")
public class RatingDaoImpl implements RatingDao {

    private EntityManager em = Persistence.createEntityManagerFactory("hibernate.ejb.entitymanager_factory_name").createEntityManager();

    @Override
    public Rating findById(int id) {
            return em.find(Rating.class, id);
        }

    @Override
    public void save(Rating rating) {
        em.getTransaction().begin();
        em.persist(rating);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void update(Rating rating){
        em.getTransaction().begin();
        em.merge(rating);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void delete(Rating rating) {
        em.getTransaction().begin();
        em.remove(rating);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public Rating findByLogin(String login) {
       List<Rating> query =  em.createQuery("select m from Rating m " +
                "where m.users.id =(select t.id from User t where t.login=:login)")
                .setParameter("login", login).getResultList();
        return query.get(0);
    }

    @Override
    public List<Rating> findAll() {
        return (List<Rating>) em.createQuery("select m from Rating m").getResultList();
    }

}
