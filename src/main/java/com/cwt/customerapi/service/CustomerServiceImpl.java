package com.cwt.customerapi.service;

import com.cwt.customerapi.dto.CustomerDTO;
import com.cwt.customerapi.entity.Customer;
import com.cwt.customerapi.exception.CustomerNotFoundException;
import com.cwt.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;


    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer cust = repository.save(new Customer(customerDTO));
        return new CustomerDTO(cust);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> dtoList = repository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public void delCustomer(Integer custId) {

    }

    @Override
    public CustomerDTO updateCustomer(Customer customer, Integer custId) {
        return null;
    }

    @Override
    public void delAllCustomers() {

    }

    @Override
    public CustomerDTO findCustomerById(Integer custId) {
        Customer customer = repository.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Available With ID : " + custId));
        return new CustomerDTO(customer);
    }
}
