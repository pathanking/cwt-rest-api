package com.cwt.customerapi.dto;

import com.cwt.customerapi.entity.Address;
import com.cwt.customerapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerDTO {

    @NotBlank(message = "First Name Can't Be Null/Blank!!")
    private String firstName;
    @NotBlank(message = "Last Name Can't Be  Null/Blank")
    private String lastName;
    @NotBlank(message = "Last Name Can't Be  Null/Blank")
    @Email(message = "Email is not properly formatted/Invalid Email")
    private String email;
    @Valid
    private AddressDTO addressDTO;

    @PastOrPresent
    private LocalDate dob;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public CustomerDTO(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        Address customerAddress = customer.getAddress();
        AddressDTO addressDTO1 = new AddressDTO(customerAddress);
        this.addressDTO = addressDTO1;
        this.dob = customer.getDob();
        this.createdOn = customer.getCreatedOn();
        this.updatedOn = customer.getUpdatedOn();
    }

}
