package com.emrekayacik.ecomm.service;

import com.emrekayacik.ecomm.base.service.BaseEntityService;
import com.emrekayacik.ecomm.dao.ProductRepository;
import com.emrekayacik.ecomm.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void updateProductPriceById(Long id, double price){
        repository.updateProductPriceById(id,price);
    }
}
