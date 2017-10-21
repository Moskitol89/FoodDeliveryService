package com.moskitol.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    private int id;
    private User user;
    private Cart cart;
    private String deliveryAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart basket) {
        this.cart = basket;
    }
    @Column(name = "delivery_address")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String address) {
        this.deliveryAddress = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", cart=" + cart +
                ", address='" + deliveryAddress + '\'' +
                '}';
    }
}
