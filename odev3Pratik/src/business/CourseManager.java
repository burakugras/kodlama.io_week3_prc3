package business;

import java.util.List;

import core.logging.Logger;
import dataAccess.CourseDao;
import entities.Course;

public class CourseManager {
    private CourseDao courseDao;
    private List<Logger> logger;

    public CourseManager(CourseDao courseDao, List<Logger> logger) {
        this.courseDao = courseDao;
        this.logger = logger;
    }

    public void add(Course course,List<Course> courses) throws Exception{//buradaki add CourseManager'e ait. Bir course (kurs) ve kurs listesi ekleniyor.
        
        for (Course courseElement : courses) {
            if(course.getCourseName().equals(courseElement.getCourseName())){
                throw new Exception("bu isimde bir kurs mevcut");
            }            
        }
        
        if(course.getPrice()<0){
            throw new Exception("kurs fiyatı 0'dan küçük olamaz");
        }

        courseDao.add(course,courses); //buradaki add CourseDao 'ya ait
        courses.add(course);//buradaki add List<Course> 'a ait
        
        for (Logger loggers : logger) {
            loggers.log(course.getCourseName()+" kursu loglandı");
        }
    }
    
}
