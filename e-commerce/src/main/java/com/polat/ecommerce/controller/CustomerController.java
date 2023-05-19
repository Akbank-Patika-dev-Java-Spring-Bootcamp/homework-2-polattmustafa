package com.polat.ecommerce.controller;

import com.polat.ecommerce.controller.contract.CustomerControllerContract;
import com.polat.ecommerce.dto.CustomerDTO;
import com.polat.ecommerce.dto.CustomerSaveRequest;
import com.polat.ecommerce.dto.CustomerDeleteRequest;
import com.polat.ecommerce.general.RestResponse;
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
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        var customerDTO = customerControllerContract.save(customerSaveRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> update(@RequestBody CustomerSaveRequest customerSaveRequest, @PathVariable Long id) {
        var customerDTO = customerControllerContract.update(id, customerSaveRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id) {
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findByUsername(@PathVariable String name) {
        var customerDTO = customerControllerContract.findByName(name);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id,
                                                       @RequestBody CustomerDeleteRequest customerDeleteRequest) {
        Boolean isDeleted = customerControllerContract.delete(id, customerDeleteRequest);
        if (isDeleted) {
            return ResponseEntity.ok(RestResponse.empty());
        } else {
            return ResponseEntity.ok(RestResponse.message(String.format("%s username and %s phone information did not match",
                            customerDeleteRequest.username(), customerDeleteRequest.phone())));
        }
    }

}
