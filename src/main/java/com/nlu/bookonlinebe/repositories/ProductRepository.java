package com.nlu.bookonlinebe.repositories;

import com.nlu.bookonlinebe.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Optional<Product> findByName(String name);
    public List<Product> findByKeywordsContainingIgnoreCase(String q);
}
