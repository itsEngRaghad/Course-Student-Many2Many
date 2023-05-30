package com.example.schoolmanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer address_id;

    private String area;
    private String street;
    private String buildingNumber;
}
