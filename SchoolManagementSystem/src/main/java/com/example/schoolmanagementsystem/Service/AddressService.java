package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.APIException.APIException;
import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Model.Address;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.AddressRepository;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    //Add teacher address
    public void addDetails(AddressDTO dto) {
        //check id
        Teacher thisteacher = teacherRepository.findTeacherById(dto.getAddress_id());
        if (thisteacher == null) {
            throw new APIException("sorry can't add details, teacher not found");
        }
        Address address = new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), thisteacher);
        addressRepository.save(address);
    }


    //Update teacher address
    public void updateDetails(AddressDTO dto) {
        //check id
        Teacher thisteacher = teacherRepository.findTeacherById(dto.getAddress_id());
        if (thisteacher == null) {
            throw new APIException("sorry can't update details, teacher not found");
        }
        Address address = addressRepository.findAddressById(dto.getAddress_id());
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(address);
    }


//    //Delete teacher address
//    public void deleteDetails(AddressDTO dto) {
//        //check id
//        Teacher thisteacher = teacherRepository.findTeacherById(dto.getAddress_id());
//        if (thisteacher == null) {
//            throw new APIException("sorry can't delete details, teacher not found");
//        }
//        Address address = new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), thisteacher);
//        addressRepository.delete(address);
//
//    }
}
