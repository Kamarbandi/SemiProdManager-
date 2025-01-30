package com.example.Manufactor.service;

import com.example.Manufactor.entity.Order;
import com.example.Manufactor.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }


    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder-> {
                    existingOrder.setDescription(updatedOrder.getDescription());
                    existingOrder.setStatus(updatedOrder.getStatus());
                    existingOrder.setStartDate(updatedOrder.getStartDate());
                    existingOrder.setEndDate(updatedOrder.getEndDate());

                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(()-> new EntityNotFoundException("Order with id: " + id + " did not Found"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
