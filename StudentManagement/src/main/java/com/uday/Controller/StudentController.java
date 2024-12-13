package com.uday.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uday.Entity.Student;
import com.uday.Service.StudentService;

import jakarta.websocket.server.PathParam;

@Controller
//@RequestMapping("/home")
public class StudentController {
	
	private StudentService  studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
}
	
    @GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
    @GetMapping("/students/new")
	public String addStudents(Model model) {
     Student student = new Student();
     model.addAttribute("student",student);
    	return "add_student";
	}
    
    @PostMapping("/students")
   	public String  saveStudent(@ModelAttribute("student") Student student) {
     studentService.saveStudent(student);
    return "redirect:/students";
    }
    
    @GetMapping("/students/edit/{id}")
   	public String editStudents(@PathVariable Long id,Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
       	return "edit_student";
   	}
    
//    @PostMapping("/students/{id}")
//   	public String  updateStudent(@PathVariable Long id,
//   			@ModelAttribute("student") Student student ,Model model) {
//    	
//   
//    	
//    	Student existinigStudent = studentService.getStudentById(id);
//    	existinigStudent.getId();
//    	existinigStudent.setFirstName(student.getFirstName());
//    	existinigStudent.setLastName(student.getLastName());
//    	existinigStudent.setEmail(student.getEmail());
//    	
//     studentService.updateStudent(existinigStudent);
//    return "redirect:/students";
//    }
//    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id); // Ensure the ID is retained
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    
    
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
    
