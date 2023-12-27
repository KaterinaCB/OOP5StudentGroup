import controler.Controler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.createStudent("Марков", "Вячеслав", "Олегович");
        controler.createStudent("Круглов", "Даниил", "Валерьевич");
        controler.createStudent("Смирнов", "Евгений", "Андреевич");
        controler.getAllStudent();
        controler.createTeacher("Мягков", "Александр", "Иванович");
        controler.createTeacher("Зотов", "Андрей", "Васильевич");
        controler.getAllTeacher();
        controler.createGroup(1, List.of(1,2,3));
        controler.getAllGroups();
    }
}