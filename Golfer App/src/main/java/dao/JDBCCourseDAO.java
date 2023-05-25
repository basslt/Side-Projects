package dao;



import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCourseDAO implements CourseDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";

    @Override
    public Course getCourseById(int courseId) {
        String query = "SELECT * FROM courses WHERE course_id = ?";
        Course course = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = extractCourseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    @Override
    public Course getCourseByLocation(String location) {
        String query = "SELECT * FROM courses WHERE location = ?";
        Course course = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, location);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = extractCourseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    @Override
    public Course getCourseByName(String name) {
        String query = "SELECT * FROM courses WHERE course_name = ?";
        Course course = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = extractCourseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }
    @Override
    public Course getCourseByCourseRating(int rating) {
        String query = "SELECT * FROM courses WHERE course_rating = ?";
        Course course = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rating);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = extractCourseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }
    @Override
    public Course getCourseBySlopeRating(int rating) {
        String query = "SELECT * FROM courses WHERE slope_rating = ?";
        Course course = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rating);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = extractCourseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }



    @Override
    public List<Course> getAllCourses() {
        String query = "SELECT * FROM courses";
        List<Course> courseList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Course course = extractCourseFromResultSet(rs);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    @Override
    public void addCourse(Course course) {
        String query = "INSERT INTO courses (course_name, location, course_rating, slope_rating) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getLocation());
            stmt.setInt(3, course.getCourseRating());
            stmt.setInt(4,course.getSlopeRating());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int courseId = generatedKeys.getInt(1);
                course.setCourseId(courseId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateCourse(Course course) {
        String query = "UPDATE courses SET course_name = ?, location = ?, course_rating = ?, slope_rating = ? WHERE course_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getLocation());
            stmt.setInt(3, course.getCourseRating());
            stmt.setInt(4,course.getSlopeRating());
            stmt.setInt(5, course.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteCourse(int courseId) {
        String query = "DELETE FROM courses WHERE course_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Course extractCourseFromResultSet(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
        course.setLocation(rs.getString("location"));
        course.setCourseRating(rs.getInt("course_rating"));
        course.setSlopeRating(rs.getInt("slope_rating"));
        return course;
    }
}
