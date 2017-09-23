package com.moskitol.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food {
    private int id;
    private String name;
    private float cost;
    private Set<Order> orders = new HashSet<Order>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "cost")
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    @ManyToMany
    @JoinTable(name = "ORDER_FOOD_DETAIL",joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns =
    @JoinColumn(name = "order_id"))
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", orders=" + orders +
                '}';
    }
}
