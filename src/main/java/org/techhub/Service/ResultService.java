package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.ResultModel;
import org.techhub.Repository.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;

	// GET ALL RESULTS
	public List<ResultModel> getAllResults() {

		return resultRepository.getAllResults();
	}

	// GET RESULTS BY STUDENT
	public List<ResultModel> getResultsByStudentId(int studentId) {

		if (studentId <= 0) {
			return List.of();
		}

		return resultRepository.getResultsByStudentId(studentId);
	}

	// SAVE RESULT
	public boolean saveResult(ResultModel result) {

		if (result == null) {
			return false;
		}

		if (result.getStudentId() <= 0) {
			return false;
		}

		if (result.getAssessmentId() <= 0) {
			return false;
		}

		if (result.getMarksObtained() < 0) {
			return false;
		}

		if (result.getResultStatus() == null || result.getResultStatus().trim().isEmpty()) {

			return false;
		}

		return resultRepository.saveResult(result);
	}

	// GET RESULT BY ID
	public ResultModel getResultById(int id) {

		if (id <= 0) {
			return null;
		}

		return resultRepository.getResultById(id);
	}

	// UPDATE RESULT
	public boolean updateResult(ResultModel result) {

		if (result == null || result.getId() <= 0) {
			return false;
		}

		if (result.getStudentId() <= 0) {
			return false;
		}

		if (result.getAssessmentId() <= 0) {
			return false;
		}

		if (result.getMarksObtained() < 0) {
			return false;
		}

		if (result.getResultStatus() == null || result.getResultStatus().trim().isEmpty()) {

			return false;
		}

		return resultRepository.updateResult(result);
	}

	// DELETE RESULT
	public boolean deleteResult(int id) {

		if (id <= 0) {
			return false;
		}

		return resultRepository.deleteResult(id);
	}
}