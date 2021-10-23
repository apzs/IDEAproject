package factory_patterns.abstractFactory;

import factory_patterns.abstractFactory.factory.Factory;
import factory_patterns.abstractFactory.factory.MySQLFactory;
import factory_patterns.abstractFactory.factory.OracleFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {
        Factory factory1 = new MySQLFactory();
        System.out.println(factory1.produceConnection().getConnection());
        System.out.println(factory1.produceStatement().getStatement());

        Factory factory2 = new OracleFactory();
        System.out.println(factory2.produceConnection().getConnection());
        System.out.println(factory2.produceStatement().getStatement());
    }
}
