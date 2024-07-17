package com.cornbread.nothingismissed;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderItemId;

    @ManyToOne
    @JoinColumn(name = "OrderId", nullable = false)
    @JsonBackReference(value = "order-orderItem")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    @JsonManagedReference(value = "orderItem-item")
    private Item item;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    public Long getOrderItemId() {
        return OrderItemId;
    }

    public void setOrderItemId(Long OrderItemId) {
        this.OrderItemId = OrderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((OrderItemId == null) ? 0 : OrderItemId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (OrderItemId == null) {
            if (other.OrderItemId != null)
                return false;
        } else if (!OrderItemId.equals(other.OrderItemId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderItem [OrderItemId=" + OrderItemId + ", order=" + order + ", item=" + item.getProductName() + ", quantity="
                + quantity + "]";
    }

    
}
