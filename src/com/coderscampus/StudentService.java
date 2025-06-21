package com.coderscampus;

import java.util.Arrays;

public class StudentService {
    static FileService fileService = new FileService();
    private static final String CVS_HEADER = "StudentID,StudentName,Course,Grade";

    public Student[] initiate(String filePath) {
        String[] lines = fileService.read(filePath);
        Student[] students = new Student[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            if (data.length != 4) {
                throw new IllegalArgumentException("Invalid CSV line: " + lines[1]);
            }
            Integer studentId = Integer.parseInt(data[0].trim());
            String studentName = data[1].trim();
            String course = data[2].trim();
            Integer grade = Integer.parseInt(data[3].trim());
            students[i] = new Student(studentId, studentName, course, grade);
        }
        Arrays.sort(students);
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
    public static void writeCourseFile(String filePath, Student[] students){
        String[] content = new String[students.length + 1];
        content[0] = CVS_HEADER;
        for (int i = 0; i < students.length; i++) {
            content[i + 1] = students[i].toString();
        }
        fileService.write(filePath, content);
    }
}
