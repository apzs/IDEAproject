public class a5_14_Student {
    private String id;
    private String name;
    private String gender;
    private int age;
    private static int count = 0;

    public a5_14_Student() {
        count++;
    }

    public a5_14_Student(String id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        count++;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        a5_14_Student.count = count;
    }

    @Override
    public String toString() {
        return "学号:" + id  +
                ", 姓名:" + name  +
                ", 性别:" + gender +
                ", 年龄:" + age;
    }
}
