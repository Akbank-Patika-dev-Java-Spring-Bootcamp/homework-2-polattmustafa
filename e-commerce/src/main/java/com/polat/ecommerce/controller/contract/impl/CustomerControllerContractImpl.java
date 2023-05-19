package com.polat.ecommerce.controller.contract.impl;

import com.polat.ecommerce.controller.contract.CustomerControllerContract;
import com.polat.ecommerce.dto.CustomerDTO;
import com.polat.ecommerce.dto.CustomerDeleteRequest;
import com.polat.ecommerce.dto.CustomerSaveRequest;
import com.polat.ecommerce.mapper.CustomerMapper;
import com.polat.ecommerce.model.Customer;
import com.polat.ecommerce.service.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerEntityService customerEntityService;

    @Override
    public CustomerDTO save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

        customer =customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerEntityService.findAll();
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customers);
    }

    @Override
    public Boolean delete(Long id, CustomerDeleteRequest customerDeleteRequest) {
        Customer customer = customerEntityService.findById(id).orElseThrow();
        if (customer.getUsername().equals(customerDeleteRequest.username())
                && customer.getPhone().equals(customerDeleteRequest.phone())) {
            customerEntityService.delete(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerEntityService.findById(id).orElseThrow();
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findByName(String name) {
        List<Customer> customers = customerEntityService.findByName(name);
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customers);
    }

    @Override
    public CustomerDTO update(Long id, CustomerSaveRequest customerSaveRequest) {
        Customer customer =  customerEntityService.findById(id).orElseThrow();
        customer.setName(customerSaveRequest.name());
        customer.setSurname(customerSaveRequest.surname());
        customer.setUsername(customerSaveRequest.username());
        customer.setPassword(customerSaveRequest.password());
        customer.setEmail(customerSaveRequest.email());
        customer.setPhone(customerSaveRequest.phone());
        customer.setType(customerSaveRequest.type());

        customer = customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }


}
