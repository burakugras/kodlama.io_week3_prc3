import java.util.ArrayList;
import java.util.List;

import business.CategoryManager;
import business.CourseManager;
import business.TeacherManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateCategoryDao;
import dataAccess.HibernateCourseDao;
import dataAccess.JdbcCourseDao;
import dataAccess.JdbcTecherDao;
import entities.Category;
import entities.Course;
import entities.Teacher;

public class App {
    public static void main(String[] args) throws Exception {

        Course courseJava=new Course("java", 150);
        Teacher teacher=new Teacher("burak uğraş");
        Category category=new Category("bilgisayar");


        List<Course> courses=new ArrayList<>();
        List<Category> categories=new ArrayList<>();        
        List<Logger> loggers=new ArrayList<>();

        loggers.add(new DatabaseLogger());
        loggers.add(new MailLogger());
        loggers.add(new FileLogger());
        
        CourseManager courseManager=new CourseManager(new JdbcCourseDao(),loggers);//burada CourseManager'ın birinci parametresi, eklenecek olan course nesnesinin hangi yöntem ile ekleneceğini belirtiyor (hibernate, jdbc vs.). İkinci parametresi ise loglayabilmek için bir liste istiyor.
        courseManager.add(courseJava, courses);

        System.out.println("--------------------------------------------------");

        TeacherManager teacherManager=new TeacherManager(new JdbcTecherDao(), loggers);
        teacherManager.add(teacher);

        System.out.println("--------------------------------------------------");

        CategoryManager categoryManager=new CategoryManager(new HibernateCategoryDao(), loggers);
        categoryManager.add(category, categories);

    }
}
