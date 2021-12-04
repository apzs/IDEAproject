package login.domain;

/**
 * @author 无名氏
 * @date 2021/9/9
 */
public class Account {

    public int id;
    public String name;
    public double account;

    public Account() {
    }

    public Account(String name, double account) {
        this.name = name;
        this.account = account;
    }

    public Account(int id, String name, double account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}
