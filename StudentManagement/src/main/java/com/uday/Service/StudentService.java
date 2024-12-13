package com.uday.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uday.Entity.Student;
@Service
public interface StudentService {
      List<Student> getAllStudents();
      Student saveStudent(Student student);
      Student updateStudent(Student student);
      Student getStudentById(Long  id);
      void deleteStudentById(Long id);


}