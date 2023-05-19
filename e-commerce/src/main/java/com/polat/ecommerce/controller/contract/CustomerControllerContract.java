package com.polat.ecommerce.controller.contract;

import com.polat.ecommerce.dto.CustomerDTO;
import com.polat.ecommerce.dto.CustomerDeleteRequest;
import com.polat.ecommerce.dto.CustomerSaveRequest;

import java.util.List;

public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequest request);

    List<CustomerDTO> findAll();

    Boolean delete(Long id, CustomerDeleteRequest customerDeleteRequest);

    CustomerDTO findById(Long id);

    CustomerDTO update(Long id, CustomerSaveRequest customerSaveRequest);

    List<CustomerDTO> findByName(String name);
}
