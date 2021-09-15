package login.exception.impl;

import login.exception.DemoService;
import login.exception.MyException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author 无名氏
 * @date 2021/9/15
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public void show1() {
        System.out.println("抛出类型转换异常。。。");
        Object str = "lisa";
        Integer num = (Integer) str;
    }

    @Override
    public void show2() {
        System.out.println("抛出除零异常。。。");
        int i = 1/0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到异常。。。");
        InputStream in = new FileInputStream("C:/xxx/xxx/xxx.txt");
    }

    @Override
    public void show4() {
        System.out.println("空指针异常。。。");
        String str = null;
        str.length();
    }

    @Override
    public void show5() throws MyException {
        System.out.println("自定义异常。。。");
        throw new MyException();
    }
}
