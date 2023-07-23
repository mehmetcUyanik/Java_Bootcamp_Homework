package Homeworks.Homework4.util;

public enum GradeEnum {

    /*
    Grade ödevde istendiği üzere Enum olarak belirlendi. Her Grade için bir string bir numeric değer girildi.
    Uygun çıktı alabilmek adına toString methodu düzenlendi.
     */

    GRADE_A ("A",4),
    GRADE_B ("B",3),
    GRADE_C ("C",2),
    GRADE_D ("D",1),
    GRADE_F ("F",0);

    final String stringValue;
    final int numericValue;

     GradeEnum (String stringValue, int numericValue){
         this.stringValue = stringValue;
         this.numericValue = numericValue;
     }

    @Override
    public String toString() {
        return "Grade " +stringValue+" corresponds to numeric grade "+numericValue;
    }

}
