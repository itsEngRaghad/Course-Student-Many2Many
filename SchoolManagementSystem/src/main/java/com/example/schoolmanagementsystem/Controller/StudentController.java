package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.APIResponse.APIResponse;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.CourseService;
import com.example.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new APIResponse("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Student student, @PathVariable Integer id){
        studentService.updateCourse(student,id);
        return ResponseEntity.status(200).body("student Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");

    }

    @PutMapping("/assign/{course_id}/{student_id}")
    public ResponseEntity assignStudentToCourses(@PathVariable Integer course_id,@PathVariable Integer student_id){
        studentService.assignStudentToCourses(course_id,student_id);
        return ResponseEntity.status(200).body("assign done");
    }

    @PutMapping("/update-major/{id}")
    public ResponseEntity updateMajor(@Valid @RequestBody Student student, @PathVariable Integer id){
        studentService.updateMajor(student,id);
        return ResponseEntity.status(200).body("student Updated");
    }


    @GetMapping("/getList/{id}")
    public ResponseEntity studentList(@PathVariable Integer id){
      List<Student> student=  studentService.studentList(id);
        return ResponseEntity.status(200).body(student);
    }

//
//    //Create endpoint that takes class id and return the student list
//
//    public Student studentList(Integer id){
//        Student student=studentRepository.findStudentById(id);
//        return student;
//    }
}
