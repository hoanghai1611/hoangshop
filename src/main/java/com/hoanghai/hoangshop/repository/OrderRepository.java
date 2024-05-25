package com.hoanghai.hoangshop.repository;
import com.hoanghai.hoangshop.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByNameContaining(String name, Pageable pageable);
}
