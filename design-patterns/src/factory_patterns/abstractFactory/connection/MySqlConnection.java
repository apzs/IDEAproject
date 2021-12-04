package factory_patterns.abstractFactory.connection;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class MySqlConnection extends Connnection{
    @Override
    public String getConnection() {
        return "获得MySQL的连接对象";
    }
}
