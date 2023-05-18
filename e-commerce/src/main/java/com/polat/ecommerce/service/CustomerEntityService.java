package com.polat.ecommerce.service;

import com.polat.ecommerce.model.Customer;
import com.polat.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

    public CustomerEntityService(CustomerRepository anyRepo) {
        super(anyRepo);
    }


    public List<Customer> findByName(String name) {
        return getAnyRepo().findByName(name);
    }
}
