import java.time.LocalDate;

public class a5_9_2_Student extends a5_8_Card{

        private String department;
        private LocalDate intoTheSchoolTime;

        public a5_9_2_Student() {
            super();
        }

        public a5_9_2_Student(String id , String name , String gender , int yearOfBirth, int monthOfBirth, int dayOfBirth,
                            String department, int yearOFSchool, int monthOfSchool, int dayOfSchool){
            super(id, name, gender, yearOfBirth,monthOfBirth,dayOfBirth);
            this.department = department;
            this.intoTheSchoolTime =LocalDate.of(yearOFSchool,monthOfSchool,dayOfSchool) ;
        }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getIntoTheSchoolTime() {
        return intoTheSchoolTime;
    }

    public void setIntoTheSchoolTime(int yearOFSchool, int monthOfSchool, int dayOfSchool) {
        this.intoTheSchoolTime =LocalDate.of(yearOFSchool,monthOfSchool,dayOfSchool) ;
    }

    @Override
        public String toString() {
            return  super.toString()+
                    " 系别:" + department + " " +
                    "入校时间:" + intoTheSchoolTime.getYear()+"年" + intoTheSchoolTime.getMonthValue() +"月"+ intoTheSchoolTime.getDayOfMonth()+"日";
        }
    

}
