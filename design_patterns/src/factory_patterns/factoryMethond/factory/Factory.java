package factory_patterns.factoryMethond.factory;

import factory_patterns.factoryMethond.connection.Connection;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public abstract class Factory {
    public abstract  Connection produceConnection();
}
