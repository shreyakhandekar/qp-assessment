package com.qp_assessment.grocery.RestController;

import com.qp_assessment.grocery.Entity.Grocery;
import com.qp_assessment.grocery.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public ResponseEntity<Grocery> addGrocery(@RequestBody Grocery grocery) {
        Grocery savedItem = groceryService.addGrocery(grocery);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping
    public ResponseEntity<List<Grocery>> viewAllGroceries() {
        List<Grocery> groceries = groceryService.getAllGrocerys();
        return ResponseEntity.ok(groceries);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGrocery(@PathVariable Long id) {
        groceryService.removeGrocery(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grocery> updateGrocery(@PathVariable Long id, @RequestBody Grocery updatedItem) {
        Grocery updatedItem2 = groceryService.updateGrocery(id, updatedItem);
        return ResponseEntity.ok(updatedItem2);
    }

    @PutMapping("/{id}/inventory")
    public ResponseEntity<Grocery> manageInventory(@PathVariable Long id, @RequestBody Map<String, Integer> inventoryMap) {
        int newInventory = inventoryMap.get("quantity");
        Grocery updatedItem = groceryService.updateInventory(id, newInventory);
        return ResponseEntity.ok(updatedItem);
    }
}
