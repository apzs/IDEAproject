package login.transaction;

/**
 * @author 无名氏
 * @date 2021/9/16
 */
public interface AccountService {

    void transfer(String outMan, String inMan, double money);
}
