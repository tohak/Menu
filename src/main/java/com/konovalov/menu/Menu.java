package com.konovalov.menu;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Menu {
@Id
    @GeneratedValue//авто инкремент
    private Long id;
@Column(nullable = false)
    private String name;
@Column(nullable = false)
    private  Integer price;
@Column(nullable = false)
    private Integer weight;
private Integer discount;

    public Menu() {
    }

    public Menu(String name, Integer price, Integer weight, Integer discount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(price, menu.price) &&
                Objects.equals(weight, menu.weight) &&
                Objects.equals(discount, menu.discount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, weight, discount);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}
