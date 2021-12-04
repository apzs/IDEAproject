package domain;

/**
 * @author 无名氏
 * @Data 2021/6/29
 */
public class UserMessage {
    private int id;
    private String name;
    private String gender;
    private String tel;
    private String qq;
    private String e_mail;
    private String address;

    public UserMessage() {
    }

    public UserMessage(String name, String gender, String tel, String qq, String e_mail, String address) {
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.qq = qq;
        this.e_mail = e_mail;
        this.address = address;
    }

    public UserMessage(int id, String name, String gender, String tel, String qq, String e_mail, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.qq = qq;
        this.e_mail = e_mail;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
