package com.qp_assessment.grocery.Service;

import com.qp_assessment.grocery.Entity.Grocery;
import com.qp_assessment.grocery.Exception.ResourceNotFoundException;
import com.qp_assessment.grocery.Repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public List<Grocery> getAllGrocerys() {
        return groceryRepository.findAll();
    }

    public void removeGrocery(Long id) {
        groceryRepository.deleteById(id);
    }

    public Grocery updateGrocery(Long id, Grocery updatedItem) {
        Grocery existingItem = groceryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery item not found with id: " + id));

        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());

        return groceryRepository.save(existingItem);
    }

    public Grocery updateInventory(Long id, int newInventory) {
        Grocery existingItem = groceryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery item not found with id: " + id));

        existingItem.setQuantity(newInventory);

        return groceryRepository.save(existingItem);
    }

    public List<Grocery> getAvailableGrocerys() {
        return groceryRepository.findByQuantityGreaterThan(0);
    }
}
