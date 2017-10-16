package com.moskitol.dao;

import com.moskitol.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static final Log LOG = LogFactory.getLog(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("From User u").list();
    }

    public User findById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        LOG.info("User save with id: " + user.getId());
    }

    public void delete(int id) {
        User user = findById(id);
        if (user != null) sessionFactory.getCurrentSession().delete(user);
    }

    public User findUserByUsername(String username) {
        for(User userFromList: findAll()) {
            if (userFromList.getUsername().equals(username)) return userFromList;
        }
        LOG.error("USER NOT FOUND! returned null");
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
