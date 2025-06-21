package com.coderscampus;

public class Student implements Comparable<Student> {
    private Integer studentId;
    private String studentName;
    private String course;
    private Integer grade;

    public Student(Integer studentId, String studentName, String course, Integer grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public Integer getID() {
        return studentId;
    }

    public void setID(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse () {
            return course;
    }

    public void setCourse (String course){
            this.course = course;
    }

    public Integer getGrade () {
            return grade;
    }

    public void setGrade (Integer grade){
            this.grade = grade;
    }

    @Override
    public String toString () {
            return studentId + "," + studentName + "," + course + "," + grade;
    }

    @Override
    public int compareTo (Student other){
        int gradeCompare = Integer.compare(other.grade, this.grade);
        return gradeCompare != 0 ? gradeCompare : Integer.compare(other.studentId, this.studentId);
    }
}


