package login.domain;

/**
 * @author 无名氏
 * @date 2021/9/5
 */
public class User2 {
    String username;
    int age;

    public User2() {
    }

    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
