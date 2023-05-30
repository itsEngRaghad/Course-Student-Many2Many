package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.APIResponse.APIResponse;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.CourseService;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        List<Course> courses=courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new APIResponse("course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id){
        courseService.updateCourse(course,id);
        return ResponseEntity.status(200).body("course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted");

    }

    //assigning method controller
    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.assignCourseToTeacher(course_id, teacher_id);
        return ResponseEntity.status(200).body("assign done");
    }

    //delete assigned branch of merchant
    @DeleteMapping("delete/{teacher_id}/{course_id}")
    public ResponseEntity deleteCourseOfTeacher(@PathVariable Integer course_id, @PathVariable Integer teacher_id){
        courseService.deleteCourseOfTeacher(teacher_id, course_id);
        return ResponseEntity.status(200).body("assigned course has been deleted");
    }


    @GetMapping("/get-Tname/{course_id}")
    //Create endpoint that takes movie name and return the director name
    public ResponseEntity returnTeacherName(@PathVariable Integer course_id){
        String teacher= courseService.returnTeacherName(course_id);
        return ResponseEntity.status(200).body(teacher);
    }


}
