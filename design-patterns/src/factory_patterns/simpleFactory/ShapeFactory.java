package factory_patterns.simpleFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class ShapeFactory {
    public static Shape getShape(String shape) throws Exception {

        if ("Circle".equals(shape)) {
            return new Circle();
        }else if ("Rectangle".equals(shape)) {
            return new Rectangle();
        }else if ("Triangle".equals(shape)) {
            return new Triangle();
        }else {
            throw new UnsupportedShapeException();
        }
    }
}
