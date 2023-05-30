package com.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Address {

//    Address Class :
//area , street , buildingNumber ( Add all required validation )

    @Id
    private Integer id;

    private String area;
    private String street;
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore //to avoid entering infinite loop with generated id and foreign id
    private Teacher teacher;
}
