package login.domain;

/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class User {
    public String company;
    public int age;

    public User() {
    }

    public User(String company, int age) {
        this.company = company;
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "company='" + company + '\'' +
                ", age=" + age +
                '}';
    }
}
