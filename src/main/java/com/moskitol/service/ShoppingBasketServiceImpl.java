package com.moskitol.service;

import com.moskitol.dao.ShoppingBasketDaoImpl;
import com.moskitol.model.ShoppingBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("shoppingBasketService")
@Transactional
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private final ShoppingBasketDaoImpl BASKETDAO;

    @Autowired
    public ShoppingBasketServiceImpl(ShoppingBasketDaoImpl basketdao) {
        BASKETDAO = basketdao;
    }

    public List findAll() {
        return BASKETDAO.findAll();
    }

    public ShoppingBasket findById(int id) {
        return BASKETDAO.findById(id);
    }

    public void delete(int id) {
        BASKETDAO.delete(id);
    }

    public void save(ShoppingBasket basket) {
        BASKETDAO.save(basket);
    }
}
