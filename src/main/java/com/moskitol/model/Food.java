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
    private Set<ShoppingBasket> shoppingBaskets = new HashSet<ShoppingBasket>();

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
    @JoinTable(name = "SHOPPING_BASKET_DETAIL", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns =
    @JoinColumn(name = "basket_id"))
    public Set<ShoppingBasket> getShoppingBaskets() {
        return shoppingBaskets;
    }

    public void setShoppingBaskets(Set<ShoppingBasket> shoppingBaskets) {
        this.shoppingBaskets = shoppingBaskets;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", shoppingBaskets=" + shoppingBaskets +
                '}';
    }
}
