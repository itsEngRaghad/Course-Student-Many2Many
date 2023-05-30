package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.APIException.APIException;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.CourseRepository;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    //    Get all courses
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    //Add new course
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    //Update course
    public void updateCourse(Course course,Integer id){
        Course oldCourse= courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new APIException("course not found");
        }

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    //Delete course
    public void deleteCourse(Integer id){
        Course course= courseRepository.findCourseById(id);
        if(course==null){
            throw new APIException("course not found");
        }

        courseRepository.delete(course);
    }


    //asign course to teacher method
    public void assignCourseToTeacher(Integer teacher_id,Integer course_id){
        //check if they both exist
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseById(course_id);
        if(teacher==null||course==null){
            throw new APIException("can't assign course, wrong id");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void deleteCourseOfTeacher(Integer teacher_id, Integer course_id){

        //check if they both exist
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseById(course_id);
        if(teacher==null||course==null){
            throw new APIException("can't delete course, wrong id");
        }
        courseRepository.delete(course);
    }

    //Create endpoint that take course id and return the teacher name for that class

    public String returnTeacherName(Integer course_id){

        Teacher teacher=teacherRepository.findTeacherById(courseRepository.findCourseById(course_id).getId());
        return teacher.getName();
    }
}

