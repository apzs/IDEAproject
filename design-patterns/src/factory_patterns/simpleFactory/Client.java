package factory_patterns.simpleFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Shape shape1 = ShapeFactory.getShape("Circle");
        shape1.draw();
        Shape shape2 = ShapeFactory.getShape("Rectangle");
        shape2.erase();
        Shape shape3 = ShapeFactory.getShape("Sphere");
        shape3.draw();
    }
}
