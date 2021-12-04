package factory_patterns.abstractFactory.factory;

import factory_patterns.abstractFactory.connection.Connnection;
import factory_patterns.abstractFactory.statement.Statement;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public abstract class Factory {
    public abstract Connnection produceConnection();
    public abstract Statement produceStatement();
}
