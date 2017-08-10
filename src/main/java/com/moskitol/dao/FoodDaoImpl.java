package com.moskitol.dao;

import com.moskitol.model.Food;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("foodDao")
public class FoodDaoImpl implements FoodDao {
    private static final Log LOG = LogFactory.getLog(FoodDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Food> findAll() {
        return sessionFactory.getCurrentSession().createQuery("From Food f").list();
    }

    public Food findById(int id) {
        return (Food) sessionFactory.getCurrentSession().get(Food.class, id);
    }

    public void save(Food food) {
        sessionFactory.getCurrentSession().saveOrUpdate(food);
        LOG.info("Food save with id: " + food.getId());
    }

    public void delete(int id) {
        Food food = findById(id);
        if (food != null) sessionFactory.getCurrentSession().delete(food);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
