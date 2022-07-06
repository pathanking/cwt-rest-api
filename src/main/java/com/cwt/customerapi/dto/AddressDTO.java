package com.cwt.customerapi.dto;

import com.cwt.customerapi.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @NoArgsConstructor @AllArgsConstructor
public class AddressDTO {
    @NotBlank(message = "City Can't Be Null/Blank!!")
    private String city;

    @NotBlank(message = "Country Can't Be Null/Blank")
    private String country;

    public AddressDTO(Address address){
        this.city = address.getCity();
        this.country = address.getCountry();
    }
}
