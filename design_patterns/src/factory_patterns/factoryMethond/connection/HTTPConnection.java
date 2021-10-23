package factory_patterns.factoryMethond.connection;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class HTTPConnection extends Connection {
    @Override
    public void getConnection() {
        System.out.println("获得HTTPConnection......");
    }

    @Override
    public void open(String connStr) {
        System.out.println("开启HTTPConnection......connStr");
    }

    @Override
    public void close() {
        System.out.println("关闭HTTPConnection......");
    }
}
