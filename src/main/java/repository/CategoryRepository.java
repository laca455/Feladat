package com.example.webshop.repository

import com.example.webshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Order, Long> {
}