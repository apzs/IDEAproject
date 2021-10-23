package factory_patterns.simpleFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class UnsupportedShapeException extends Exception{
    public  UnsupportedShapeException() {
        super("不支持该几何图形");
    }
}
