package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.AttendanceModel;
import org.techhub.Repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    public List<AttendanceModel> getAttendanceByStudentId(
            int studentId) {

        if (studentId <= 0) {
            return List.of();
        }

        return attendanceRepository
                .getAttendanceByStudentId(studentId);
    }


    public int getTotalClasses(int studentId) {

        if (studentId <= 0) {
            return 0;
        }

        return attendanceRepository
                .getTotalClasses(studentId);
    }


    public int getPresentClasses(int studentId) {

        if (studentId <= 0) {
            return 0;
        }

        return attendanceRepository
                .getPresentClasses(studentId);
    }


    public int getAbsentClasses(int studentId) {

        if (studentId <= 0) {
            return 0;
        }

        return attendanceRepository
                .getAbsentClasses(studentId);
    }


    public double getAttendancePercentage(int studentId) {

        int total =
                getTotalClasses(studentId);

        int present =
                getPresentClasses(studentId);

        if (total == 0) {
            return 0;
        }

        return (present * 100.0) / total;
    }
}