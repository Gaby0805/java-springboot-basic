package dev.gaby.Fridge.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Notation
@Entity
@Table(name = "food_table")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer quantity;
    private LocalDateTime expiration;

    public Food(long id, String name, Integer quantity, LocalDateTime expiration) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiration = expiration;
    }
    public Food(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }
}
