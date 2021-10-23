package factory_patterns.abstractFactory.factory;

import factory_patterns.abstractFactory.connection.Connnection;
import factory_patterns.abstractFactory.connection.OracleConnection;
import factory_patterns.abstractFactory.statement.OracleStatement;
import factory_patterns.abstractFactory.statement.Statement;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class OracleFactory extends Factory{
    @Override
    public Connnection produceConnection() {
        return new OracleConnection();
    }

    @Override
    public Statement produceStatement() {
        return new OracleStatement();
    }
}
