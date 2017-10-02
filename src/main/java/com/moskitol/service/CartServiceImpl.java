package com.moskitol.service;

import com.moskitol.dao.CartDao;
import com.moskitol.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    private final CartDao CARTDAO;

    @Autowired
    public CartServiceImpl(CartDao basketDao) {
        CARTDAO = basketDao;
    }

    public List findAll() {
        return CARTDAO.findAll();
    }

    public Cart findById(int id) {
        return CARTDAO.findById(id);
    }

    public void delete(int id) {
        CARTDAO.delete(id);
    }

    public void save(Cart basket) {
        CARTDAO.save(basket);
    }
}
