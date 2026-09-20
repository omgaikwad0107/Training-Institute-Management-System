package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.FacultyResultModel;
import org.techhub.Repository.FacultyResultRepository;

@Service
public class FacultyResultService {

    @Autowired
    private FacultyResultRepository facultyResultRepository;


    public List<FacultyResultModel>
    getAssessmentsByFacultyUsername(String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return List.of();
        }

        return facultyResultRepository
                .getAssessmentsByFacultyUsername(username);
    }


    public boolean isAssessmentAssignedToFaculty(
            int assessmentId,
            String username) {

        if (assessmentId <= 0 ||
            username == null ||
            username.trim().isEmpty()) {

            return false;
        }

        return facultyResultRepository
                .isAssessmentAssignedToFaculty(
                        assessmentId,
                        username
                );
    }


    public List<FacultyResultModel>
    getStudentsByAssessment(int assessmentId) {

        if (assessmentId <= 0) {
            return List.of();
        }

        return facultyResultRepository
                .getStudentsByAssessment(assessmentId);
    }


    @Transactional
    public boolean saveResult(
            int studentId,
            int assessmentId,
            int marksObtained,
            String resultStatus,
            String remarks,
            String facultyUsername) {


        if (studentId <= 0 ||
            assessmentId <= 0 ||
            marksObtained < 0 ||
            resultStatus == null ||
            resultStatus.trim().isEmpty() ||
            facultyUsername == null ||
            facultyUsername.trim().isEmpty()) {

            return false;
        }


        boolean assessmentAssigned =
                facultyResultRepository
                .isAssessmentAssignedToFaculty(
                        assessmentId,
                        facultyUsername
                );

        if (!assessmentAssigned) {
            return false;
        }


        boolean studentValid =
                facultyResultRepository
                .isStudentValidForAssessment(
                        studentId,
                        assessmentId,
                        facultyUsername
                );

        if (!studentValid) {
            return false;
        }


        List<FacultyResultModel> students =
                facultyResultRepository
                .getStudentsByAssessment(
                        assessmentId
                );


        int totalMarks = 0;

        for (FacultyResultModel student : students) {

            if (student.getStudentId() == studentId) {

                totalMarks =
                        student.getTotalMarks();

                break;
            }
        }


        if (marksObtained > totalMarks) {
            return false;
        }


        boolean exists =
                facultyResultRepository
                .resultExists(
                        studentId,
                        assessmentId
                );


        if (exists) {

            return facultyResultRepository
                    .updateResult(
                            studentId,
                            assessmentId,
                            marksObtained,
                            resultStatus,
                            remarks
                    );
        }


        return facultyResultRepository
                .saveResult(
                        studentId,
                        assessmentId,
                        marksObtained,
                        resultStatus,
                        remarks
                );
    }
}