package com.cornbread.nothingismissed;


import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private final OrderService orderServ = null;

    @Autowired
    private final CustomerService customerServ = null;

    @Autowired
    private final ItemService itemServ = null;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderServ.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderServ.getOrderById(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody OrderRequest orderRequest) {
        Order order = new Order();
        order.setCustomer(customerServ.getCustomerById(orderRequest.getCustomerId()));
        order.setOrderDate(new Date());
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : orderRequest.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(itemServ.getItemById(itemRequest.getItemId()));
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return orderServ.saveOrder(order);
    }
    
    @PutMapping("/{orderId}/orderItems")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody List<OrderItemRequest> newOrderItems) {
        return orderServ.updateOrderItems(orderId, newOrderItems);
    }

    @DeleteMapping("/{orderId}/orderItems/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId) {
        orderServ.deleteOrderItem(orderId, orderItemId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderServ.deleteOrderById(id);
    }
}

class OrderRequest {
    private Long customerId;
    private List<OrderItemRequest> items;
    
    public OrderRequest(Long customerId, List<OrderItemRequest> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}

class OrderItemRequest {
    private Long itemId;
    private Integer quantity;
    
    public OrderItemRequest(Long itemId, Integer quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}