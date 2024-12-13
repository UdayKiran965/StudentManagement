package com.uday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	

}
