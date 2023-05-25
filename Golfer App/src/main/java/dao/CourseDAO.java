package dao;

import model.Course;

import java.util.List;

public interface CourseDAO {
    Course getCourseById(int courseId);

    Course getCourseByLocation(String location);

    Course getCourseByName(String name);

    Course getCourseByCourseRating(int rating);

    Course getCourseBySlopeRating(int rating);

    List<Course> getAllCourses();
    void addCourse(Course course);
    void updateCourse(Course course);

    void deleteCourse(int courseId);
}
