package com.cwt.customerapi.entity;


import com.cwt.customerapi.dto.AddressDTO;
import com.cwt.customerapi.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="cwt_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;
    @Column(name = "first_name", length = 20, updatable = true)
    private String firstName;
    private String lastName;
    @Column(name = "email", length = 255, unique = true,nullable = false)
    private String email;

    @Embedded
    private Address address;
    private LocalDate dob;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Customer(CustomerDTO dto){
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        AddressDTO addressDTO = dto.getAddressDTO();
        Address address1 = new Address(addressDTO);
        this.address = address1;
        this.dob = dto.getDob();
    }

    @PrePersist
    public void created_on(){
        this.createdOn = LocalDateTime.now();
    }

    @PostUpdate
    public void updated_on(){
        this.updatedOn = LocalDateTime.now();
    }

}

