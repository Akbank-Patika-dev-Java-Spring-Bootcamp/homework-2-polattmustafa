package com.polat.ecommerce.controller.contract;

import com.polat.ecommerce.dto.product.ProductDTO;
import com.polat.ecommerce.dto.product.ProductSaveRequest;

import java.util.List;

public interface ProductControllerContract {

    ProductDTO save(ProductSaveRequest productSaveRequest);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void delete(long id);

    ProductDTO updatePrice(Long id, double price);
}
