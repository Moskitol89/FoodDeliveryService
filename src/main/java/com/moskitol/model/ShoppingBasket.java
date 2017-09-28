package com.moskitol.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SHOPPING_BASKET")
public class ShoppingBasket {
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
    @OneToOne(mappedBy = "basket",fetch = FetchType.LAZY)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @ManyToMany
    @JoinTable(name = "SHOPPING_BASKET_DETAIL", joinColumns = @JoinColumn(name = "basket_id"), inverseJoinColumns =
    @JoinColumn(name = "food_id"))
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
        getFoods().remove(food);
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "id=" + id +
                ", order=" + order +
                ", foods=" + foods +
                '}';
    }
}
