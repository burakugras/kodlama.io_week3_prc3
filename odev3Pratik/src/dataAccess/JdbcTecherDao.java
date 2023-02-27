package dataAccess;

import entities.Teacher;

public class JdbcTecherDao implements TeacherDao{

    @Override
    public void add(Teacher teacher) {
        System.out.println("eğitmen Jdbc ile eklendi");
    }
    
}
