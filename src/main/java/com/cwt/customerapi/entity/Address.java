package com.cwt.customerapi.entity;

import com.cwt.customerapi.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embeddable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class Address {
    private String city;
    private String country;

    public Address(AddressDTO dto){
        this.city = dto.getCity();
        this.country = dto.getCountry();
    }
}
