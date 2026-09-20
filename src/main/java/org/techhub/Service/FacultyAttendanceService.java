package org.techhub.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.FacultyAttendanceModel;
import org.techhub.Repository.FacultyAttendanceRepository;

@Service
public class FacultyAttendanceService {

    @Autowired
    private FacultyAttendanceRepository facultyAttendanceRepository;


    // =====================================================
    // GET FACULTY STUDENTS
    // =====================================================

    public List<FacultyAttendanceModel> getStudentsByFacultyUsername(
            String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return List.of();
        }

        return facultyAttendanceRepository
                .getStudentsByFacultyUsername(username);
    }


    // =====================================================
    // SAVE / UPDATE ATTENDANCE
    // =====================================================

    @Transactional
    public boolean saveAttendance(
            int studentId,
            LocalDate attendanceDate,
            String status,
            String remarks,
            String facultyUsername) {

        if (studentId <= 0 ||
            attendanceDate == null ||
            status == null ||
            status.trim().isEmpty() ||
            facultyUsername == null ||
            facultyUsername.trim().isEmpty()) {

            return false;
        }


        // Security check:
        // Student faculty च्या assigned batch मधला आहे का?

        boolean assigned =
                facultyAttendanceRepository
                .isStudentAssignedToFaculty(
                        studentId,
                        facultyUsername
                );

        if (!assigned) {
            return false;
        }


        // Same student + same date already exists

        boolean exists =
                facultyAttendanceRepository
                .attendanceExists(
                        studentId,
                        attendanceDate
                );


        if (exists) {

            return facultyAttendanceRepository
                    .updateAttendance(
                            studentId,
                            attendanceDate,
                            status,
                            remarks
                    );
        }


        return facultyAttendanceRepository
                .saveAttendance(
                        studentId,
                        attendanceDate,
                        status,
                        remarks
                );
    }


    // =====================================================
    // TODAY PRESENT COUNT
    // =====================================================

    public int getTodayPresentCountByFacultyUsername(
            String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return 0;
        }

        return facultyAttendanceRepository
                .getTodayPresentCountByFacultyUsername(username);
    }
}