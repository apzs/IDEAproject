public class Student extends Person{
    private String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("  性别:" + gender);
    }
}
