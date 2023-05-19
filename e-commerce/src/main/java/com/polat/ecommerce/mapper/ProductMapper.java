package com.polat.ecommerce.mapper;

import com.polat.ecommerce.dto.product.ProductDTO;
import com.polat.ecommerce.dto.product.ProductSaveRequest;
import com.polat.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequest request);

    ProductDTO convertToProductDTO(Product product);

    List<ProductDTO> convertToProductDTOList(List<Product> productList);

}
