package model;

import java.util.List;

public class StudentGroup {
    private int groupId;
    private int teacherId;
    private List<Integer> studentGroup;

    public StudentGroup(int groupId, int teacherId, List<Integer> studentGroup) {
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.studentGroup = studentGroup;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int studentGroupId) {
        this.groupId = studentGroupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(List<Integer> studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "studentGroupId=" + groupId +
                ", teacherId=" + teacherId +
                ", studentGroup=" + studentGroup +
                '}';
    }
}
