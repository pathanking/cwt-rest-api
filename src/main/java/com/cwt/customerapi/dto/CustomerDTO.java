package com.cwt.customerapi.dto;

import com.cwt.customerapi.entity.Address;
import com.cwt.customerapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO addressDTO;
    private LocalDate dob;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public CustomerDTO(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        Address customerAddress = customer.getAddress();
        this.addressDTO.setCity(customerAddress.getCity());
        this.addressDTO.setCountry(customerAddress.getCountry());
        this.dob = customer.getDob();
        this.createdOn = customer.getCreatedOn();
        this.updatedOn = customer.getUpdatedOn();
    }

}
