package com.polat.ecommerce.mapper;

import com.polat.ecommerce.dto.customer.CustomerDTO;
import com.polat.ecommerce.dto.customer.CustomerSaveRequest;
import com.polat.ecommerce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOList (List<Customer> customers);

}
