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
    private Set<Cart> Carts = new HashSet<Cart>();

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SHOPPING_BASKET_DETAIL", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns =
    @JoinColumn(name = "basket_id"))
    public Set<Cart> getCarts() {
        return Carts;
    }

    public void setCarts(Set<Cart> Carts) {
        this.Carts = Carts;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", Carts=" + Carts +
                '}';
    }
}
