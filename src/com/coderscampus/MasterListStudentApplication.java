package com.coderscampus;

public class MasterListStudentApplication {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        StudentService studentService = new StudentService();
        String[] lines = fileService.read("student-master-list.csv");
        Student[] students = studentService.parseStudents(lines);
        Student[][] courses = studentService.splitByCourse(students);
        studentService.sortCourses(courses);
        String csvHeader = "StudentID,StudentName,Course,Grade";

        writeCourseFile(fileService, "course1.csv", csvHeader, courses[0]);
        writeCourseFile(fileService, "course2.csv", csvHeader, courses[1]);
        writeCourseFile(fileService, "course3.csv", csvHeader, courses[2]);
    }
        private static void writeCourseFile(FileService fileService, String filePath, String header, Student[] students){
            String[] content = new String[students.length + 1];
            content[0] = header;
            for (int i = 0; i < students.length; i++) {
                content[i + 1] = students[i].toCSV();
            }
            fileService.write(filePath, content);
        }
    }

