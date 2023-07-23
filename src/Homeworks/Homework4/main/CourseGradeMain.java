package Homeworks.Homework4.main;

import Homeworks.Homework4.util.CourseGrade;
import Homeworks.Homework4.util.GradeEnum;

public class CourseGradeMain {
    public static void main(String[] args) {

        CourseGrade courseGrade = new CourseGrade("ZOMP",96,12, GradeEnum.GRADE_A);
        courseGrade.setGradeTaken(GradeEnum.GRADE_B);
        courseGrade.setCourseDepartment("ECE");
        courseGrade.setCourseCredit(3);
        courseGrade.setCourseCredit(7);
        courseGrade.setGradeTaken(10.2);
        courseGrade.setCourseCode(473);

        System.out.println(courseGrade);

        CourseGrade courseGrade1 = new CourseGrade("MATH");

        System.out.println(courseGrade1);
    }
}
