package com.qp_assessment.grocery.Repository;

import com.qp_assessment.grocery.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
