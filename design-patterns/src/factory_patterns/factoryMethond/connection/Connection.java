package factory_patterns.factoryMethond.connection;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public abstract class Connection {
    public abstract void getConnection();
    public abstract void open(String connStr);
    public abstract void close();

}
