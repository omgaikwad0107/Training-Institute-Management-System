package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.AssessmentModel;
import org.techhub.Repository.AdminAssessmentRepository;

@Service
public class AdminAssessmentService {

    @Autowired
    private AdminAssessmentRepository assessmentRepository;

    // =====================================================
    // GET ALL
    // =====================================================

    public List<AssessmentModel> getAllAssessments() {
        return assessmentRepository.getAllAssessments();
    }

    // =====================================================
    // GET UPCOMING
    // =====================================================

    public List<AssessmentModel> getUpcomingAssessments() {
        return assessmentRepository.getUpcomingAssessments();
    }

    // =====================================================
    // GET COMPLETED
    // =====================================================

    public List<AssessmentModel> getCompletedAssessments() {
        return assessmentRepository.getCompletedAssessments();
    }

    // =====================================================
    // GET BY STATUS
    // =====================================================

    public List<AssessmentModel> getAssessmentsByStatus(String status) {

        if (status == null || status.trim().isEmpty()) {
            return getAllAssessments();
        }

        return assessmentRepository.getAssessmentsByStatus(
                status.trim().toUpperCase()
        );
    }

    // =====================================================
    // GET BY COURSE
    // =====================================================

    public List<AssessmentModel> getAssessmentsByCourse(String courseName) {

        if (courseName == null || courseName.trim().isEmpty()) {
            return getAllAssessments();
        }

        return assessmentRepository.getAssessmentsByCourse(
                courseName.trim()
        );
    }

    // =====================================================
    // GET BY BATCH
    // =====================================================

    public List<AssessmentModel> getAssessmentsByBatch(String batchName) {

        if (batchName == null || batchName.trim().isEmpty()) {
            return getAllAssessments();
        }

        return assessmentRepository.getAssessmentsByBatch(
                batchName.trim()
        );
    }

    // =====================================================
    // COUNTS
    // =====================================================

    public int getTotalAssessments() {
        return assessmentRepository.getTotalAssessments();
    }

    public int getTotalUpcoming() {
        return assessmentRepository.getTotalUpcoming();
    }

    public int getTotalCompleted() {
        return assessmentRepository.getTotalCompleted();
    }
}