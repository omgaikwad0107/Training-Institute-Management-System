package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.CourseModel;
import org.techhub.Repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Add Course
    @Transactional
    public boolean saveCourse(CourseModel course) {

        if (course == null) {
            return false;
        }

        if (course.getStatus() == null || course.getStatus().trim().isEmpty()) {
            course.setStatus("ACTIVE");
        }

        return courseRepository.saveCourse(course);
    }

    // Get All Courses
    public List<CourseModel> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    // Get Course By ID
    public CourseModel getCourseById(int id) {

        if (id <= 0) {
            return null;
        }

        return courseRepository.getCourseById(id);
    }

    // Update Course
    @Transactional
    public boolean updateCourse(CourseModel course) {

        if (course == null) {
            return false;
        }

        if (course.getId() <= 0) {
            return false;
        }

        return courseRepository.updateCourse(course);
    }

    // Delete Course
    @Transactional
    public boolean deleteCourse(int id) {

        if (id <= 0) {
            return false;
        }

        return courseRepository.deleteCourse(id);
    }

    // Get Active Courses
    public List<CourseModel> getActiveCourses() {
        return courseRepository.getActiveCourses();
    }

    // Get Total Courses
    public int getTotalCourses() {
        return courseRepository.getTotalCourses();
    }
}