package com.ironhacker.JavaPottersHomework3.models;

import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ProductEnum productEnum;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    public Opportunity() {
    }

    public Opportunity(ProductEnum productEnum, int quantity, Contact decisionMaker, StatusEnum statusEnum) {
        this.productEnum = productEnum;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.statusEnum = statusEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductEnum getProductEnum() {
        return productEnum;
    }

    public void setProductEnum(ProductEnum productEnum) {
        this.productEnum = productEnum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", productEnum=" + productEnum +
                ", quantity=" + quantity +
                ", statusEnum=" + statusEnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return id == that.id && quantity == that.quantity && productEnum == that.productEnum && statusEnum == that.statusEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productEnum, quantity, statusEnum);
    }

    public void setStatus(StatusEnum closedLost) {
    }
}
