package com.cornbread.nothingismissed;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepo = null;

    // @Autowired
    // private final OrderItemRepository orderitemRepo = null;

    // @Autowired
    // private final CustomerService customerServ = null;

    @Autowired
    private final ItemService itemServ = null;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
            .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order deleteOrderItem(Long orderId, Long orderItemId) {
        Order order = getOrderById(orderId);
        order.getOrderItems().removeIf(item -> item.getOrderItemId().equals(orderItemId));
        return orderRepo.save(order);
    }

    @Transactional
    public Order updateOrderItems(Long orderId, List<OrderItemRequest> newOrderItems) {
        Order order = getOrderById(orderId);
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : newOrderItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(itemServ.getItemById(itemRequest.getItemId()));
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return orderRepo.save(order);
    }

    public void deleteOrderById(Long id) {
        orderRepo.deleteById(id);
    }
}
