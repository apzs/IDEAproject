package login.domain;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/5
 */
public class VO {
    List<User2> userList;

    public List<User2> getUserList() {
        return userList;
    }

    public void setUserList(List<User2> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
