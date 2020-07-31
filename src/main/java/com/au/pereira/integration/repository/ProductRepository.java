package com.au.pereira.integration.repository;


import com.au.pereira.integration.model.Category;
import com.au.pereira.integration.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
