package login.transaction;

/**
 * @author 无名氏
 * @date 2021/9/16
 */
public interface AccountDao {

    void out(String outMan, double money);

    void in(String inMan, double money);
}
