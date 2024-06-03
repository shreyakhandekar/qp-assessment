package com.qp_assessment.grocery.Service;

import com.qp_assessment.grocery.Entity.Grocery;
import com.qp_assessment.grocery.Entity.Order;
import com.qp_assessment.grocery.Repository.GroceryRepository;
import com.qp_assessment.grocery.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroceryRepository groceryRepository;

    public Order bookItems(List<Grocery> itemsToBook) {
        // Create a new order
        Order order = new Order();
        order.setItems(itemsToBook);

        // Calculate total price
        double totalPrice = calculateTotalPrice(itemsToBook);
        order.setTotalPrice(totalPrice);

        // Update inventory levels
        updateInventory(itemsToBook);

        // Save the order to the database
        return orderRepository.save(order);
    }

    private double calculateTotalPrice(List<Grocery> items) {
        double totalPrice = 0;
        for (Grocery item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    private void updateInventory(List<Grocery> items) {
        for (Grocery item : items) {
            int remainingQuantity = item.getQuantity() - 1; // Assuming booking decrements quantity by 1
            item.setQuantity(remainingQuantity);
            // Save updated item to database (may vary based on your implementation)
            groceryRepository.save(item);
        }
    }
}
