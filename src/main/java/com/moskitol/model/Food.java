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
    private Cart cart;
    private String imageTitle;
    private String description;
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
    @Column(name = "image_title")
    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
