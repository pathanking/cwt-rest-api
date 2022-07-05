package com.cwt.customerapi.service;

import com.cwt.customerapi.dto.CustomerDTO;
import com.cwt.customerapi.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Integer custId);
    void delCustomer(Integer custId);
    CustomerDTO updateCustomer(Customer customer,Integer custId);
    void delAllCustomers();
}
