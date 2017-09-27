package com.moskitol.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    private int id;
    private double amount;
    private User user;
    private ShoppingBasket basket;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
    @JoinColumn(name = "basket_id")
    public ShoppingBasket getBasket() {
        return basket;
    }

    public void setBasket(ShoppingBasket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", user=" + user +
                ", basket=" + basket +
                '}';
    }
}
