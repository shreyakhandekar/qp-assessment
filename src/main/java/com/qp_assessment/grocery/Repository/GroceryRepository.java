package com.qp_assessment.grocery.Repository;

import com.qp_assessment.grocery.Entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {

    List<Grocery> findByQuantityGreaterThan(int quantity);

}
