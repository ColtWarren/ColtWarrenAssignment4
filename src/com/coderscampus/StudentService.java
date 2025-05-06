package com.coderscampus;

import java.util.Arrays;

public class StudentService {

    public Student[] parseStudents(String[] lines) {
        Student[] students = new Student[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            Integer studentId = Integer.parseInt(data[0].trim());
            String studentName = data[1].trim();
            String course = data[2].trim();
            Integer grade = Integer.parseInt(data[3].trim());
            students[i] = new Student(studentId, studentName, course, grade);
            if (data.length != 4) {
                throw new IllegalArgumentException("Invalid CSV line: " + lines[1]);
            }
        }
        return students;
    }

    public Student[][] splitByCourse(Student[] students) {
        int compsciCount = 0,  apmthCount = 0, statCount = 0;
        for (Student student : students) {
            String department = student.getCourse().split(" ")[0];
            if (department.equals("COMPSCI")) compsciCount++;
            else if (department.equals("APMTH")) apmthCount++;
            else if (department.equals("STAT")) statCount++;
            }

            Student[] compsci = new Student[compsciCount];
            Student[] apmth = new Student[apmthCount];
            Student[] stat = new Student[statCount];

            int course1 = 0, course2 = 0, course3 = 0;
            for (Student student : students) {
                String department = student.getCourse().split(" ")[0];
                if (department.equals("COMPSCI")) {
                    compsci[course1++] = student;
                } else if (department.equals("APMTH")) {
                    apmth[course2++] = student;
                } else if (department.equals("STAT")) {
                    stat[course3++] = student;
                }
            }
            return new Student[][]{compsci, apmth, stat};
    }

    public void sortCourses(Student[][] courses) {
        for (Student[] course : courses) {
            Arrays.sort(course);
        }
    }
}
