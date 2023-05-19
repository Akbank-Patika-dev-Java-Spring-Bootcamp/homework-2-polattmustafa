package com.polat.ecommerce.controller;

import com.polat.ecommerce.controller.contract.ProductControllerContract;
import com.polat.ecommerce.controller.contract.impl.ProductControllerContractImpl;
import com.polat.ecommerce.dto.customer.CustomerDTO;
import com.polat.ecommerce.dto.customer.CustomerSaveRequest;
import com.polat.ecommerce.dto.product.ProductDTO;
import com.polat.ecommerce.dto.product.ProductSaveRequest;
import com.polat.ecommerce.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;

    @PostMapping("/save")
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest productSaveRequest) {
        var productDTO = productControllerContract.save(productSaveRequest);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll() {
        var productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id) {
        var productDTO = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> delete(@PathVariable Long id) {
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> update(@PathVariable Long id,
                                                           @RequestParam double price) {
        var productDTO = productControllerContract.updatePrice(id, price);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

}
