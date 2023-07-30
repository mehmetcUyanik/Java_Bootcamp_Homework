package Homeworks.Homework4.util;

public class CourseGrade {

    /*
    CourseGrade nesnesi oluşturmak için gerekli alanlar belirlendi. Ödev içeriğinde belirtilen kısıtlamalara ve
    yönlendirmelere göre bu alanların uygun şekilde doldurulabilmesi için methodlar yazıldı.
    Ödevde istenen şekilde constructorlar oluşturuldu.
    Ödeve uygun bir çıktı alabilmek için toString methodu düzenlendi.
     */

    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private GradeEnum gradeTaken;


    public CourseGrade(String courseDepartment) {
        this.setCourseDepartment(courseDepartment);
        this.courseCode = 100;
        this.courseCredit = 4;
        this.gradeTaken = GradeEnum.GRADE_F;
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.courseCredit = 4;
        this.gradeTaken = GradeEnum.GRADE_F;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.gradeTaken = GradeEnum.GRADE_F;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, GradeEnum gradeTaken) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, double gradeTaken) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {

        if(courseDepartment.equals("CENG") ||
                courseDepartment.equals("COMP") ||
                courseDepartment.equals("ECE") ||
                courseDepartment.equals("ME") ||
                courseDepartment.equals("MATH")){

            this.courseDepartment = courseDepartment;
        }else{
            this.courseDepartment = "CENG";
        }

    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {

        if (courseCode >= 100 && courseCode <= 599){
            this.courseCode = courseCode;
        }else{
            this.courseCode = 100;
        }

    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit ==4){
            this.courseCredit = courseCredit;
        }else{
            this.courseCredit = 4;
        }


    }

    public GradeEnum getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(GradeEnum gradeTaken) {
        for (GradeEnum grades : GradeEnum.values()){
            if (gradeTaken==grades){
                this.gradeTaken = gradeTaken;
                break;
            }else {
                this.gradeTaken = GradeEnum.GRADE_F;
            }
        }

    }

    public void setGradeTaken(double val) {
        if (val >= 0 && val<=4){
            int gradeValue = (int) Math.round(val);
            if (gradeValue == 4){
                this.gradeTaken = GradeEnum.GRADE_A;
            }else if (gradeValue == 3){
                this.gradeTaken = GradeEnum.GRADE_B;
            }else if (gradeValue == 2){
                this.gradeTaken = GradeEnum.GRADE_C;
            }else if (gradeValue == 1){
                this.gradeTaken = GradeEnum.GRADE_D;
            }else {
                this.gradeTaken = GradeEnum.GRADE_F;
            }

        }else {
            this.gradeTaken = GradeEnum.GRADE_F;
        }
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " CourseCode: " + courseCode +" Credit: "+courseCredit+" Grade: "+gradeTaken.stringValue+"\n";

    }
}
