package com.polat.ecommerce.service;

import com.polat.ecommerce.model.Product;
import com.polat.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository>{

    public ProductEntityService(ProductRepository anyRepo) {
        super(anyRepo);
    }
}
