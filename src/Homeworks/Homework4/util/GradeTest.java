package Homeworks.Homework4.util;

public class GradeTest {
    public static void main(String[] args) {

        /*
        Enum olarak belirlenen Grade değerleri test edildi.
         */

        System.out.println(GradeEnum.GRADE_A);

        System.out.println("*********");

        for (GradeEnum grades: GradeEnum.values()){
            System.out.println(grades);
        }

    }
}
