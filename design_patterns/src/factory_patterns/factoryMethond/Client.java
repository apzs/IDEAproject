package factory_patterns.factoryMethond;

import factory_patterns.factoryMethond.connection.Connection;
import factory_patterns.factoryMethond.factory.Factory;
import factory_patterns.factoryMethond.factory.HTTPConnectionFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new HTTPConnectionFactory();
        Connection connection = factory.produceConnection();
        connection.getConnection();
        connection.open("conn1");
        connection.close();
    }
}
