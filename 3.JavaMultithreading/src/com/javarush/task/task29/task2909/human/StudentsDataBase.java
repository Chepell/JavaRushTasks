package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    // Передача всего объекта. Перепиши метод addInfoAboutStudent(),
    // чтобы он в качестве параметра принимал объект типа Student.
    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);
    }

    // Замена параметра вызовом метода. Перепиши метод printInfoAboutStudent(), чтобы он не
    // требовал в качестве параметра имя студента, а получал его, вызвав соответствующий метод у переданного объекта.
    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    // Замена исключения проверкой условия.
    // Перепиши метод removeStudent(int index), чтобы
    //он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
    //исключение.
    public static void removeStudent(int index) {
        if (0 <= index && index < students.size()) {
            students.remove(index);
        }
    }

    // 8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
    //работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
    //break.
    public static void findDimaOrSasha() {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals("Dima")) {
                System.out.println("Студент Dima есть в базе.");
                break;
            }

            if (students.get(i).getName().equals("Sasha")) {
                System.out.println("Студент Sasha есть в базе.");
                break;
            }
        }
    }
}