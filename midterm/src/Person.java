public class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo(){
        System.out.print("姓名:" + name + "  年龄:" + age);
    }
}
