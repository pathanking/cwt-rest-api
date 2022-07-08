package com.cwt.customerapi.controller;

import com.cwt.customerapi.dto.CustomerDTO;
import com.cwt.customerapi.service.CustomerService;
import com.cwt.customerapi.service.ValidatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private CustomerService service;

    @PostMapping("create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        Map<String,String> errorMap =  validatorService.validate(bindingResult);
        if(errorMap.isEmpty())
            return new ResponseEntity<>(service.saveCustomer(customerDTO), HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getAll")
    public List<CustomerDTO> getCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/{custId}")
    public CustomerDTO getCustomerById(@PathVariable Integer custId){
        return service.findCustomerById(custId);
    }





}
