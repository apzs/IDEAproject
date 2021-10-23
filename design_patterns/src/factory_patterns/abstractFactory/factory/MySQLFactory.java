package factory_patterns.abstractFactory.factory;

import factory_patterns.abstractFactory.connection.Connnection;
import factory_patterns.abstractFactory.connection.MySqlConnection;
import factory_patterns.abstractFactory.statement.MySQLStatement;
import factory_patterns.abstractFactory.statement.Statement;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class MySQLFactory extends Factory{
    @Override
    public Connnection produceConnection() {
        return new MySqlConnection();
    }

    @Override
    public Statement produceStatement() {
        return new MySQLStatement();
    }
}
