package com.emrekayacik.ecomm.dao;

import com.emrekayacik.ecomm.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product p set p.price = ?2 where p.id = ?1")
    @Transactional
    void updateProductPriceById(Long id, double price);
}

