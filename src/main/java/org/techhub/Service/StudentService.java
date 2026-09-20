package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.StudentModel;
import org.techhub.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// =========================================================
	// SAVE STUDENT
	// =========================================================

	@Transactional
	public boolean saveStudent(StudentModel student) {

		if (student == null) {
			return false;
		}

		// Student role is fixed
		student.setRole("STUDENT");

		// Default status
		if (student.getStatus() == null || student.getStatus().trim().isEmpty()) {
			student.setStatus("ACTIVE");
		}

		return studentRepository.saveStudent(student);
	}

	// =========================================================
	// GET ALL STUDENTS
	// =========================================================

	public List<StudentModel> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	// =========================================================
	// GET STUDENT BY ID
	// =========================================================

	public StudentModel getStudentById(int id) {

		if (id <= 0) {
			return null;
		}

		return studentRepository.getStudentById(id);
	}

	// =========================================================
	// UPDATE STUDENT
	// =========================================================

	@Transactional
	public boolean updateStudent(StudentModel student) {

	    if (student == null) {
	        return false;
	    }

	    if (student.getId() <= 0) {
	        return false;
	    }

	    return studentRepository.updateStudent(student);
	}
	// =========================================================
	// DELETE STUDENT
	// =========================================================

	public boolean deleteStudent(int id) {

		if (id <= 0) {
			return false;
		}

		return studentRepository.deleteStudent(id);
	}
	
	public int getTotalStudents() {
	    return studentRepository.getTotalStudents();
	}

	public int getActiveStudents() {
	    return studentRepository.getActiveStudents();
	}

	public int getInactiveStudents() {
	    return studentRepository.getInactiveStudents();
	}

	public int getCompletedStudents() {
	    return studentRepository.getCompletedStudents();
	}
	
	public int getTotalCourses() {
	    return studentRepository.getTotalCourses();
	}


	public int getTotalFaculty() {
	    return studentRepository.getTotalFaculty();
	}


	public int getTotalBatches() {
	    return studentRepository.getTotalBatches();
	}
	////////////////////////////////
	public StudentModel getStudentByUsername(String username) {

	    if (username == null || username.trim().isEmpty()) {
	        return null;
	    }

	    return studentRepository.getStudentByUsername(username);
	}
}