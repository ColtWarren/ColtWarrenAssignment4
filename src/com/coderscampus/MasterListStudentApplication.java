package com.coderscampus;

public class MasterListStudentApplication {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student[] students = studentService.initiate("student-master-list.csv");
        Student[][] courses = studentService.splitByCourse(students);
        StudentService.writeCourseFile("course1.csv",courses[0]);
        StudentService.writeCourseFile("course2.csv",courses[1]);
        StudentService.writeCourseFile("course3.csv",courses[2]);
        }
    }

