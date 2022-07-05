package com.cwt.customerapi.dto;

import com.cwt.customerapi.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AddressDTO {
    private String city;
    private String country;

    public AddressDTO(Address address){
        this.city = address.getCity();
        this.country = address.getCountry();
    }
}
