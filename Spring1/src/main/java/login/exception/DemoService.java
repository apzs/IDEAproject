package login.exception;

import java.io.FileNotFoundException;

/**
 * @author 无名氏
 * @date 2021/9/15
 */
public interface DemoService {
    public void show1();

    public void show2();

    public void show3() throws FileNotFoundException;

    public void show4();

    public void show5() throws MyException;
}
