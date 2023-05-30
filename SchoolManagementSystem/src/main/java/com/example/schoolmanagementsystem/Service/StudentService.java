package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.APIException.APIException;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.CourseRepository;
import com.example.schoolmanagementsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    //    Get all student
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Add new student
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    //Update student
    public void updateCourse(Student student,Integer id){
        Student oldStudent= studentRepository.findStudentById(id);
        if(oldStudent==null){
            throw new APIException("student not found");
        }

        oldStudent.setName(student.getName());
        studentRepository.save(oldStudent);
    }

    //Delete student
    public void deleteStudent(Integer id){
        Student student= studentRepository.findStudentById(id);
        if(student==null){
            throw new APIException("student not found");
        }

        studentRepository.delete(student);
    }


    public void assignStudentToCourses(Integer course_id,Integer student_id){

        Student student=studentRepository.findStudentById(student_id);
        Course course=courseRepository.findCourseById(course_id);

        if(course==null||student==null){
            throw new APIException("wrong id, can't assign");
        }

        student.getCourses().add(course); //take given courses then set them in student
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    //    Create endpoint that takes student id and major and change the student major
    //    ( changing the major will drop all the cousres that the student attended to )


//    public void updateMajor(Integer id,String major){
//        Student student=studentRepository.findStudentById(id);
//        if(student==null){
//            throw new APIException("no id found");
//        }
//        student.setMajor(student.getMajor());
//        student.getCourses().remove(student.getCourses());
//        studentRepository.save(student);
//    }

    public void updateMajor(Student student, Integer id){
        Student student1= studentRepository.findStudentById(id);
        if(student1==null){
            throw new APIException("student not found");
        }

       student1.setMajor(student.getMajor());
        student1.getCourses().remove(student1.getCourses());
        studentRepository.save(student1);

    }

    //Create endpoint that takes class id and return the student list

    public List<Student> studentList(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);

        List<Student> student=studentRepository.getStudentsByCoursesId(course_id);
        return student;

    }



}
