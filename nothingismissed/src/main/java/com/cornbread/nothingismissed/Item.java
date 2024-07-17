package com.cornbread.nothingismissed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Amount")
    private Long amount;
    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<OrderItem> orderItems = new ArrayList<>();

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item))
            return false;
        Item item = (Item) o;
        return Objects.equals(this.ProductId, item.ProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ProductId, this.productName);
    }

    @Override
    public String toString() {
        return "Item{id=" + this.ProductId + ", Name=" + this.productName + ", Price=$" + this.price + ", Amount=" + this.amount + "}";
    }

}