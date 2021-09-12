import java.time.LocalDate;

public  class a5_8_Card {
    private String id = null;
    private  String name = null;
    private String gender = null;
    private LocalDate dateOfBirth =LocalDate.of(1970,1,1);

    public a5_8_Card() {
    }

    public a5_8_Card(String id, String name, String gender, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int yearOfBirth, int monthOfBirth,int dayOfBirth) {
        this.dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
    }

    @Override
    public String toString() {
        return "编号:" + getId() + " " +
                "姓名:" + getName() + " " +
                "性别:" + getGender() + " " +
                "出生年月:" + getDateOfBirth().getYear() +"年"+ getDateOfBirth().getMonthValue() +"月"+ getDateOfBirth().getDayOfMonth() +"日";
    }
}
