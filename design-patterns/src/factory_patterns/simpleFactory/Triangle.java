package factory_patterns.simpleFactory;

/**
 * @author 无名氏
 * @date 2021/10/21
 * @Description: TODO
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }

    @Override
    public void erase() {
        System.out.println("擦除三角形");
    }
}
