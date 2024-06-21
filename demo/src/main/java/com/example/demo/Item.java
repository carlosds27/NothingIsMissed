package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Productid;
    @Column(name = "ProductName")
    private String ProductName;
    @Column(name = "Price")
    private Double Price;
    @Column(name = "Amount")
    private Long Amount;

    Item() {}

    Item(String ProductName, Double Price, Long Amount) {
        this.ProductName = ProductName;
        this.Price = Price;
        this.Amount = Amount;
    }

    public Long getId() {
        return this.Productid;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public Double getPrice() {
        return this.Price;
    }

    public Long getAmount() {
        return this.Amount;
    }

    public void setId(Long Productid) {
        this.Productid = Productid;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public void setAmount(Long Amount) {
        this.Amount = Amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item))
            return false;
        Item item = (Item) o;
        return Objects.equals(this.Productid, item.Productid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.Productid, this.ProductName);
    }

    @Override
    public String toString() {
        return "Item{id=" + this.Productid + ", Name=" + this.ProductName + ", Price=$" + this.Price + ", Amount=" + this.Amount + "}";
    }
}
