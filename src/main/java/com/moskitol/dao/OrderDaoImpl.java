package com.moskitol.dao;

import com.moskitol.model.Order;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    private static final Log LOG = LogFactory.getLog(OrderDaoImpl.class);
    private SessionFactory sessionFactory;

    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Order o").list();
    }

    public Order findById(int id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
        LOG.info("Order save : " + order.getId());
    }

    public void delete(int id) {
        Order order = findById(id);
        if(order != null) sessionFactory.getCurrentSession().delete(order);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
