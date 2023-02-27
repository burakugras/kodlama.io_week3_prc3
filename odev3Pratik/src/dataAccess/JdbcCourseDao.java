package dataAccess;

import java.util.List;

import entities.Course;

public class JdbcCourseDao implements CourseDao{

    @Override
    public void add(Course course, List<Course> courses) {
        System.out.println("kurs Jdbc ile eklendi");
    }

    
    
}
