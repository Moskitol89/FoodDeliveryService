package com.moskitol.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    private int id;
    private Order order;
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
    @OneToOne(mappedBy = "cart",fetch = FetchType.LAZY)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, orphanRemoval = true)
    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public void addFood(Food food) {
        if(food != null) {
            getFoods().add(food);
        }
    }

    public void removeFood(Food food) {
        for (Food foodFromSet : new HashSet<Food>(getFoods())) {
            if(foodFromSet.getName().equals(food.getName())) {
                getFoods().remove(foodFromSet);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", order=" + order +
                ", foods=" + foods +
                '}';
    }
}
