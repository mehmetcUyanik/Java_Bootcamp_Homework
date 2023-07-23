package Homeworks.Homework4.main;

import Homeworks.Homework4.util.CourseGrade;
import Homeworks.Homework4.util.GradeEnum;
import Homeworks.Homework4.util.Transcript;

public class TranscriptMain {
    public static void main(String[] args) {

        Transcript transcript = new Transcript(123456);

        CourseGrade courseGrade = new CourseGrade("MATH",101,4, GradeEnum.GRADE_A);
        CourseGrade courseGrade2 = new CourseGrade("ECE",102,3, GradeEnum.GRADE_C);
        CourseGrade courseGrade3 = new CourseGrade("COMP",103,4, GradeEnum.GRADE_B);
        CourseGrade courseGrade4 = new CourseGrade("ME",104,3, GradeEnum.GRADE_D);

        transcript.addCourseTaken(courseGrade);
        transcript.addCourseTaken(courseGrade2);
        transcript.addCourseTaken(courseGrade3);
        transcript.addCourseTaken(courseGrade4);

        System.out.println(transcript);
    }




}
