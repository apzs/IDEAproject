package factory_patterns.abstractFactory.statement;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class MySQLStatement extends Statement{
    @Override
    public String getStatement() {
        return "获得MySQL的语句对象";
    }
}
