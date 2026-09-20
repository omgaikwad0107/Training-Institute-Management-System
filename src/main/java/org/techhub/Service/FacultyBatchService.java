package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.BatchModel;
import org.techhub.Repository.FacultyBatchRepository;

@Service
public class FacultyBatchService {

	@Autowired
	private FacultyBatchRepository facultyBatchRepository;

	// =====================================================
	// GET FACULTY BATCHES
	// =====================================================

	public List<BatchModel> getBatchesByFacultyUsername(String username) {

		if (username == null || username.trim().isEmpty()) {
			return List.of();
		}

		return facultyBatchRepository.getBatchesByFacultyUsername(username);
	}

	// =====================================================
	// GET TOTAL BATCHES
	// =====================================================

	public int getTotalBatchesByFacultyUsername(String username) {

		if (username == null || username.trim().isEmpty()) {
			return 0;
		}

		return facultyBatchRepository.getTotalBatchesByFacultyUsername(username);
	}

}