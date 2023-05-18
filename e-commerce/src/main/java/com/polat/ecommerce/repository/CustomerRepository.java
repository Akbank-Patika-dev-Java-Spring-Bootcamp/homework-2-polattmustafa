package com.polat.ecommerce.repository;

import com.polat.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);
}
