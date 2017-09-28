package com.moskitol.dao;

import com.moskitol.model.ShoppingBasket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("BasketDao")
public class ShoppingBasketDaoImpl implements ShoppingBasketDao {
    private static final Log LOG = LogFactory.getLog(ShoppingBasketDaoImpl.class);
    private SessionFactory sessionFactory;

    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM ShoppingBasket s").list();
    }

    public ShoppingBasket findById(int id) {
        return sessionFactory.getCurrentSession().get(ShoppingBasket.class, id);
    }

    public void delete(int id) {
        ShoppingBasket shoppingBasket = findById(id);
        if(shoppingBasket != null) sessionFactory.getCurrentSession().delete(shoppingBasket);
    }

    public void save(ShoppingBasket basket) {
        sessionFactory.getCurrentSession().save(basket);
        LOG.info("Shopping basket save with id: " + basket.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
