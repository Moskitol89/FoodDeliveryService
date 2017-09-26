package com.moskitol.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    private int id;
    private double amount;
    private User user;
    private Set<Food> foods = new HashSet<Food>();

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

    @ManyToMany
    @JoinTable(name = "ORDER_FOOD_DETAIL", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns =
    @JoinColumn(name = "food_id"))
    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public void addFood(Food food) {
        getFoods().add(food);
    }

    public void removeFood(Food food) {
        getFoods().remove(food);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", user=" + user +
                ", foods=" + foods +
                '}';
    }
}
