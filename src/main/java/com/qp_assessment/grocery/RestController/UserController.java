package com.qp_assessment.grocery.RestController;

import com.qp_assessment.grocery.Entity.Grocery;
import com.qp_assessment.grocery.Entity.Order;
import com.qp_assessment.grocery.Service.GroceryService;
import com.qp_assessment.grocery.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private GroceryService groceryService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/view-grocery-items")
    public ResponseEntity<List<Grocery>> viewAvailableGrocerys() {
        List<Grocery> groceries = groceryService.getAvailableGrocerys();
        return ResponseEntity.ok(groceries);
    }

    @PostMapping("/book-grocery-items")
    public ResponseEntity<Order> bookGrocerys(@RequestBody List<Grocery> itemsToBook) {
        Order order = orderService.bookItems(itemsToBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
