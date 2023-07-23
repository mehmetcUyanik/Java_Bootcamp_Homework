package Homeworks.Homework4.util;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private int studentID;

    private List<CourseGrade> courseGrades;

    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public List<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(List<CourseGrade> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public double getGPA() {
        double totalPoint = 0;
        double totalCredit = 0;
        for (CourseGrade courseGrade:courseGrades){
            totalPoint += (courseGrade.getGradeTaken().numericValue)*(courseGrade.getCourseCredit());
            totalCredit += courseGrade.getCourseCredit();
        }

        GPA = totalPoint / totalCredit;

        return GPA;
    }

    public void setGPA(double GPA) {
        if (GPA >=0 && GPA <=4){
            this.GPA = GPA;
        }
    }


    public void addCourseTaken (CourseGrade courseGrade){
        if (getCourseGrades()!=null){
            courseGrades.add(courseGrade);
        }else {
            List<CourseGrade> courseGradeList = new ArrayList<>();
            courseGradeList.add(courseGrade);
            setCourseGrades(courseGradeList);
        }

    }

    @Override
    public String toString() {

        String print = "Student ID: " + studentID + "\n" + courseGrades.toString() + "GPA: "+getGPA();

        print = print.replace(", ", "")
                .replace("[", "")
                .replace("]", "").trim();


        return print;

    }
}
