package controler;

import model.*;
import service.DataService;
import view.StudentGroupView;
import view.StudentView;
import view.TeacherView;

import java.util.List;

public class Controler {
    private final DataService service = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudentGroupView groupView = new StudentGroupView();
    public void createStudent(String firstName, String secondName, String lastName){
        service.create(firstName, secondName,lastName, Type.STUDENT);
    }
    public void getAllStudent(){
        for(User user : service.getAllStudent()){
            studentView.printOnConsole((Student) user);
        }
    }
    public void createTeacher(String firstName, String secondName, String lastName){
        service.create(firstName, secondName,lastName, Type.TEACHER);
    }
    public void getAllTeacher(){
        for(User user : service.getUser(Type.TEACHER)){
            teacherView.printOnConsole((Teacher)user);
        }
    }

    public void createGroup(int teacherId, List<Integer> studentGroup){
        service.createStudentGroup(teacherId, studentGroup);
    }
    public void getAllGroups(){
        for(StudentGroup studentGroup : service.getGroup()){
            groupView.printOnConsoleStudentGroup(studentGroup);
        }
    }

}
