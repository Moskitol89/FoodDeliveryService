package com.moskitol.dao;

import com.moskitol.model.Cart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("CartDao")
public class CartDaoImpl implements CartDao {
    private static final Log LOG = LogFactory.getLog(CartDaoImpl.class);
    private SessionFactory sessionFactory;

    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Cart s").list();
    }

    public Cart findById(int id) {
        return sessionFactory.getCurrentSession().get(Cart.class, id);
    }

    public void delete(int id) {
        Cart Cart = findById(id);
        if(Cart != null) sessionFactory.getCurrentSession().delete(Cart);
    }

    public void save(Cart basket) {
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
