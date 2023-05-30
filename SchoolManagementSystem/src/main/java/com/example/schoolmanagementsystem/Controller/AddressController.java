package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @PostMapping("/add")
    public ResponseEntity addTeacherDetails(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addDetails(addressDTO);
        return ResponseEntity.status(200).body("details added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody@Valid AddressDTO addressDTO){
        addressService.updateDetails(addressDTO);
        return ResponseEntity.status(200).body("details updated");
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity deleteDetails(AddressDTO addressDTO){
//        addressService.deleteDetails(addressDTO);
//        return ResponseEntity.status(200).body("Details has been deleted");
//    }
}
