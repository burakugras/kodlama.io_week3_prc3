package entities;

public class Teacher {
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }
    
}
