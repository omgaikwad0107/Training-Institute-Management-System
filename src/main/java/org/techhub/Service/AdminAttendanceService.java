package org.techhub.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.AdminAttendanceModel;
import org.techhub.Repository.AdminAttendanceRepository;

@Service
public class AdminAttendanceService {

    @Autowired
    private AdminAttendanceRepository repository;


    public List<AdminAttendanceModel> getAllAttendance() {

        return repository.getAllAttendance();
    }


    public List<AdminAttendanceModel> getAttendanceByDate(
            LocalDate date) {

        if (date == null) {
            return List.of();
        }

        return repository.getAttendanceByDate(date);
    }


    public List<AdminAttendanceModel> getAttendanceByStatus(
            String status) {

        if (status == null ||
            status.trim().isEmpty()) {

            return repository.getAllAttendance();
        }

        return repository.getAttendanceByStatus(
                status
        );
    }


    public int getTotalRecords() {

        return repository.getTotalRecords();
    }


    public int getTotalPresent() {

        return repository.getTotalPresent();
    }


    public int getTotalAbsent() {

        return repository.getTotalAbsent();
    }


    public double getAttendancePercentage() {

        int total = getTotalRecords();

        int present = getTotalPresent();

        if (total == 0) {
            return 0;
        }

        return (present * 100.0) / total;
    }
}