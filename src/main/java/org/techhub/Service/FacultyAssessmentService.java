package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.AssessmentModel;
import org.techhub.Repository.FacultyAssessmentRepository;

@Service
public class FacultyAssessmentService {

    @Autowired
    private FacultyAssessmentRepository
            facultyAssessmentRepository;


    // Faculty चे assigned batches
    public List<String> getBatchesByFacultyUsername(
            String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return List.of();
        }

        return facultyAssessmentRepository
                .getBatchesByFacultyUsername(username);
    }


    // Faculty चे assessments
    public List<AssessmentModel>
    getAssessmentsByFacultyUsername(
            String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return List.of();
        }

        return facultyAssessmentRepository
                .getAssessmentsByFacultyUsername(username);
    }


    // Batch faculty चा आहे का?
    public boolean isBatchAssignedToFaculty(
            String batchName,
            String username) {

        if (batchName == null ||
            batchName.trim().isEmpty() ||
            username == null ||
            username.trim().isEmpty()) {

            return false;
        }

        return facultyAssessmentRepository
                .isBatchAssignedToFaculty(
                        batchName,
                        username
                );
    }


    // Assessment save
    @Transactional
    public boolean saveAssessment(
            AssessmentModel assessment,
            String facultyUsername) {

        if (assessment == null) {
            return false;
        }

        if (facultyUsername == null ||
            facultyUsername.trim().isEmpty()) {

            return false;
        }

        if (assessment.getBatchName() == null ||
            assessment.getBatchName().trim().isEmpty()) {

            return false;
        }

        if (assessment.getCourseName() == null ||
            assessment.getCourseName().trim().isEmpty()) {

            return false;
        }

        if (assessment.getAssessmentName() == null ||
            assessment.getAssessmentName().trim().isEmpty()) {

            return false;
        }

        if (assessment.getAssessmentDate() == null) {
            return false;
        }

        if (assessment.getTotalMarks() <= 0) {
            return false;
        }


        // Security check
        boolean assigned =
                facultyAssessmentRepository
                .isBatchAssignedToFaculty(
                        assessment.getBatchName(),
                        facultyUsername
                );

        if (!assigned) {
            return false;
        }


        // Status automatically set
        if (assessment.getStatus() == null ||
            assessment.getStatus().trim().isEmpty()) {

            assessment.setStatus("UPCOMING");
        }

        return facultyAssessmentRepository
                .saveAssessment(assessment);
    }


    // Delete assessment
    @Transactional
    public boolean deleteAssessment(
            int id,
            String facultyUsername) {

        if (id <= 0 ||
            facultyUsername == null ||
            facultyUsername.trim().isEmpty()) {

            return false;
        }

        /*
         * Delete करण्याआधी assessment
         * faculty च्या batch मधला आहे का
         * हे controller/repository level वर
         * पुढे secure करू शकतो.
         */

        return facultyAssessmentRepository
                .deleteAssessment(id);
    }
}