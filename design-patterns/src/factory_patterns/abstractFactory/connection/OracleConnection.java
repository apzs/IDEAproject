package factory_patterns.abstractFactory.connection;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class OracleConnection extends Connnection{
    @Override
    public String getConnection() {
        return "获得Oracle的连接对象";
    }
}
