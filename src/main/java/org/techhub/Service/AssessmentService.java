package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.AssessmentModel;
import org.techhub.Repository.AssessmentRepository;

@Service
public class AssessmentService {

	@Autowired
	private AssessmentRepository assessmentRepository;

	// =====================================================
	// GET ALL ASSESSMENTS
	// =====================================================

	public List<AssessmentModel> getAllAssessments() {

		return assessmentRepository.getAllAssessments();
	}

	// =====================================================
	// GET ASSESSMENTS BY BATCH
	// =====================================================

	public List<AssessmentModel> getAssessmentsByBatch(String batchName) {

		if (batchName == null || batchName.trim().isEmpty()) {

			return List.of();
		}

		return assessmentRepository.getAssessmentsByBatch(batchName);
	}

	// =====================================================
	// SAVE ASSESSMENT
	// =====================================================

	public boolean saveAssessment(AssessmentModel assessment) {

		if (assessment == null) {
			return false;
		}

		if (assessment.getBatchName() == null || assessment.getBatchName().trim().isEmpty()) {

			return false;
		}

		if (assessment.getCourseName() == null || assessment.getCourseName().trim().isEmpty()) {

			return false;
		}

		if (assessment.getAssessmentName() == null || assessment.getAssessmentName().trim().isEmpty()) {

			return false;
		}

		if (assessment.getAssessmentDate() == null) {
			return false;
		}

		if (assessment.getTotalMarks() <= 0) {
			return false;
		}

		if (assessment.getStatus() == null || assessment.getStatus().trim().isEmpty()) {

			assessment.setStatus("UPCOMING");
		}

		return assessmentRepository.saveAssessment(assessment);
	}

	// =====================================================
	// GET ASSESSMENT BY ID
	// =====================================================

	public AssessmentModel getAssessmentById(int id) {

		if (id <= 0) {
			return null;
		}

		return assessmentRepository.getAssessmentById(id);
	}

	// =====================================================
	// UPDATE ASSESSMENT
	// =====================================================

	public boolean updateAssessment(AssessmentModel assessment) {

		if (assessment == null || assessment.getId() <= 0) {

			return false;
		}

		return assessmentRepository.updateAssessment(assessment);
	}

	// =====================================================
	// DELETE ASSESSMENT
	// =====================================================

	public boolean deleteAssessment(int id) {

		if (id <= 0) {
			return false;
		}

		return assessmentRepository.deleteAssessment(id);
	}
}