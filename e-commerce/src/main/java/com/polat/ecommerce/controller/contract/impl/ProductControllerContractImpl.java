package com.polat.ecommerce.controller.contract.impl;

import com.polat.ecommerce.controller.contract.ProductControllerContract;
import com.polat.ecommerce.dto.product.ProductDTO;
import com.polat.ecommerce.dto.product.ProductSaveRequest;
import com.polat.ecommerce.mapper.ProductMapper;
import com.polat.ecommerce.model.Product;
import com.polat.ecommerce.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;

    @Override
    public ProductDTO save(ProductSaveRequest request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductMapper.INSTANCE.convertToProductDTOList(productList);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productEntityService.findById(id).orElseThrow();
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public void delete(long id) {
        productEntityService.delete(id);
    }

    @Override
    public ProductDTO updatePrice(Long id, double price) {
        Product product = productEntityService.findById(id).orElseThrow();
        product.setPrice(price);
        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
}
