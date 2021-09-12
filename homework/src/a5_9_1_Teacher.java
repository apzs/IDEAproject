import java.time.LocalDate;

public class a5_9_1_Teacher extends a5_8_Card {
    private String work;
    private LocalDate issueDate;

    public a5_9_1_Teacher(String id , String name , String gender , int yearOfBirth, int monthOfBirth, int dayOfBirth,
                          String work, int yearOFIssuance, int monthOfIssuance, int dayOfIssuance){
        super(id, name, gender, yearOfBirth,monthOfBirth,dayOfBirth);
        this.work = work;
        this.issueDate =LocalDate.of(yearOFIssuance,monthOfIssuance,dayOfIssuance) ;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(int yearOFIssuance,int monthOfIssuance,int dayOfIssuance) {
        this.issueDate =LocalDate.of(yearOFIssuance,monthOfIssuance,dayOfIssuance) ;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " 职务:" + work + " " +
                "签发时间:" + issueDate.getYear() +"年"+ issueDate.getMonthValue() + "月" +issueDate.getDayOfMonth() + "日";
    }
}
