package com.polat.ecommerce.controller;

import com.polat.ecommerce.controller.contract.CustomerControllerContract;
import com.polat.ecommerce.dto.CustomerDTO;
import com.polat.ecommerce.dto.CustomerSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        var customerDTO = customerControllerContract.save(customerSaveRequest);
        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerSaveRequest customerSaveRequest, @PathVariable Long id) {
        var customerDTO = customerControllerContract.update(id, customerSaveRequest);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(customerDTOList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerDTO>> findByUsername(@PathVariable String name) {
        var customerDTO = customerControllerContract.findByName(name);
        return ResponseEntity.ok(customerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         @RequestParam String username,
                         @RequestParam String phone) {
        Boolean isDeleted = customerControllerContract.delete(id, username, phone);
        return isDeleted ? String.format("Customer with id %d has been deleted", id)
                : String.format("%s username and %s phone information did not match", username, phone);

    }


}
