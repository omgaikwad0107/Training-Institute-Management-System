package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.StudentModel;
import org.techhub.Repository.FacultyStudentRepository;

@Service
public class FacultyStudentService {

	@Autowired
	private FacultyStudentRepository facultyStudentRepository;

	public List<StudentModel> getStudentsByFacultyUsername(String username) {

		if (username == null || username.trim().isEmpty()) {
			return List.of();
		}

		return facultyStudentRepository.getStudentsByFacultyUsername(username);
	}
}