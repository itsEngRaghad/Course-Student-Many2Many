package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.APIResponse.APIResponse;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

   private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        List<Teacher> teachers=teacherService.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity returnTeacher(@PathVariable Integer id){
        Teacher teacher=teacherService.returnTeacher(id);
        return ResponseEntity.status(200).body(teacher);
    }


        @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new APIResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");

    }
}
