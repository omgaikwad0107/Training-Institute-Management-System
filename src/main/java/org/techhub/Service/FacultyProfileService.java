package org.techhub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.techhub.Model.FacultyModel;
import org.techhub.Repository.FacultyProfileRepository;

@Service
public class FacultyProfileService {

    @Autowired
    private FacultyProfileRepository
            facultyProfileRepository;

    // ==================================================
    // Get Faculty Profile
    // ==================================================

    public FacultyModel getFacultyByUsername(
            String username) {

        if (username == null ||
            username.trim().isEmpty()) {

            return null;
        }

        return facultyProfileRepository
                .getFacultyByUsername(username);
    }
}