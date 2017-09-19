package com.moskitol.service;

import com.moskitol.dao.OrderDao;
import com.moskitol.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDao ORDERDAO;

    @Autowired
    public OrderServiceImpl(OrderDao orderdao) {
        ORDERDAO = orderdao;
    }

    public List<Order> findAll() {
        return ORDERDAO.findAll();
    }

    public Order findById(int id) {
        return ORDERDAO.findById(id);
    }

    public void save(Order order) {
        ORDERDAO.save(order);
    }

    public void delete(int id) {
        ORDERDAO.delete(id);
    }
}
