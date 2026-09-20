package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.FacultyModel;
import org.techhub.Repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Add Faculty
    @Transactional
    public boolean saveFaculty(FacultyModel faculty) {

        if (faculty == null) {
            return false;
        }

        faculty.setRole("FACULTY");

        if (faculty.getStatus() == null || faculty.getStatus().trim().isEmpty()) {
            faculty.setStatus("ACTIVE");
        }

        return facultyRepository.saveFaculty(faculty);
    }

    // Get All Faculty
    public List<FacultyModel> getAllFaculty() {
        return facultyRepository.getAllFaculty();
    }

    // Get Faculty By ID
    public FacultyModel getFacultyById(int id) {

        if (id <= 0) {
            return null;
        }

        return facultyRepository.getFacultyById(id);
    }

    // Update Faculty
    @Transactional
    public boolean updateFaculty(FacultyModel faculty) {

        if (faculty == null) {
            return false;
        }

        if (faculty.getId() <= 0) {
            return false;
        }

        return facultyRepository.updateFaculty(faculty);
    }

    // Delete Faculty
    @Transactional
    public boolean deleteFaculty(int id) {

        if (id <= 0) {
            return false;
        }

        return facultyRepository.deleteFaculty(id);
    }

    // Get Active Faculty
    public List<FacultyModel> getActiveFaculty() {
        return facultyRepository.getActiveFaculty();
    }

    // Get Total Faculty
    public int getTotalFaculty() {
        return facultyRepository.getTotalFaculty();
    }
}