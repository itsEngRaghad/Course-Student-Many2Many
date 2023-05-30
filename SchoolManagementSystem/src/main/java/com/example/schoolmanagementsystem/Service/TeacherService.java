package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.APIException.APIException;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    //    Get all teachers
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    //Add new teacher
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    //Update teacher
    public void updateTeacher(Teacher teacher,Integer id){
        Teacher oldTeacher= teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new APIException("teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    //Delete teacher
    public void deleteTeacher(Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new APIException("teacher not found");
        }

        teacherRepository.delete(teacher);
    }

    //    Create endpoint that takes teacher id and return All teacher details
        public Teacher returnTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
            if(teacher==null){
                throw new APIException("teacher not found");
            }
            return teacher;
        }
}
