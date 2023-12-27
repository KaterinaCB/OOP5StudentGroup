package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList;
    private List<StudentGroup> groupList;

    public DataService() {
        this.userList = new ArrayList<>();
        this.groupList = new ArrayList<>();
    }

    public void create(String firstName, String secondName, String lastName, Type type){
        int id = getMaxId(type);
        if(type == Type.STUDENT){
            userList.add(new Student(firstName, secondName,lastName,id));
        }
        if(type == Type.TEACHER){
            userList.add(new Teacher(firstName, secondName,lastName,id));
        }
    }

    private int getMaxId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for(User user : userList){
            if(user instanceof Teacher && !itsStudent){
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if(user instanceof Student && itsStudent){
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }
    public List<User> getAllStudent(){
        List<User> resultList = new ArrayList<>();
        for(User user : userList){
            if(user instanceof Student){
                resultList.add(user);
            }
        }
        return resultList;
    }

    public List<User> getUser(Type type){
        List<User> resultList = new ArrayList<>();
        boolean itsStudent = type == Type.STUDENT;
        for(User user : userList){
            if(user instanceof Student && itsStudent){
                resultList.add(user);
            }
            if(user instanceof Teacher && !itsStudent){
                resultList.add(user);
            }
        }
        return resultList;
    }

    public void createStudentGroup(int teacherId, List<Integer> studentGroup){
        int id = getMaxIdGroup();
        groupList.add(new StudentGroup(id, teacherId, studentGroup));
    }
    private int getMaxIdGroup(){
        int maxId = 1;
        for(StudentGroup studentGroup : groupList){
            if(studentGroup.getGroupId() >= maxId){
                maxId = studentGroup.getGroupId() + 1;
            }
        }
        return maxId;
    }

    public List<StudentGroup> getGroup(){
        List<StudentGroup> resultList = groupList;
        return resultList;
    }

    public User getUserById(int id, Type type){
        for(User user : getUser(type)){
            if(type == Type.STUDENT && id == ((Student)user).getStudentId()){
                return user;
            }
            if(type == Type.TEACHER && id == ((Teacher)user).getTeacherId()){
                return user;
            }
        }
        return null;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<StudentGroup> getGroupList() {
        return groupList;
    }
}
