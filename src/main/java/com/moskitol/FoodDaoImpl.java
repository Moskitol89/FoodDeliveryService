package com.moskitol;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("foodDao")
public class FoodDaoImpl implements com.moskitol.FoodDao {
    private static final Log LOG = LogFactory.getLog(FoodDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Food> findAll() {
        return sessionFactory.getCurrentSession().createQuery("From Food c").list();
    }

    public Food findById(int id) {
        return null;
    }

    public Food save(Food food) {
        return null;
    }

    public void delete(Food food) {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
