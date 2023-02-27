package dataAccess;

import java.util.List;

import entities.Course;

public class HibernateCourseDao implements CourseDao {

    @Override
    public void add(Course course, List<Course> courses) {
        System.out.println("Kurs hibernate ile eklendi");
    }

    
    
}
