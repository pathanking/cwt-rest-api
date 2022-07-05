package com.cwt.customerapi.controller;

import com.cwt.customerapi.dto.CustomerDTO;
import com.cwt.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(service.saveCustomer(customerDTO), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public List<CustomerDTO> getCustomers(){
        return service.getAllCustomers();
    }





}
