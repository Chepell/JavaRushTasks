package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();
    private Student studentWithMinAvrGrade;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }


//    public Student getStudentWithAverageGrade(double value) {
//        for (Student student : students) {
//            if (student.getAverageGrade() == value) {
//                return student;
//            }
//        }
//        return null;
//    }

    public Student getStudentWithAverageGrade(double value) {
        return students
                .stream()
                .filter(student -> value == student.getAverageGrade())
                .findFirst()
                .get();
    }

//    public Student getStudentWithMaxAverageGrade() {
//        Student studentWithMaxAvrGrade = students.get(0);
//        double maxAvr = studentWithMaxAvrGrade.getAverageGrade();
//        for (Student student : students) {
//            if (student.getAverageGrade() > maxAvr) {
//                studentWithMaxAvrGrade = student;
//            }
//        }
//        return studentWithMaxAvrGrade;
//    }

    public Student getStudentWithMaxAverageGrade() {
        return students
                .stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .get();
    }

//    public Student getStudentWithMinAverageGrade() {
//        Student studentWithMinAvrGrade = students.get(0);
//        double minAvr = studentWithMinAvrGrade.getAverageGrade();
//        for (Student student : students) {
//            if (student.getAverageGrade() < minAvr) {
//                studentWithMinAvrGrade = student;
//            }
//        }
//        return studentWithMinAvrGrade;
//    }

    public Student getStudentWithMinAverageGrade() {
        return students
                .stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade))
                .get();
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}