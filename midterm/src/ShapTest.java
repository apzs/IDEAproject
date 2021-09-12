public class ShapTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        shapes[0]= new Circle(2);
        shapes[1]=new Triangle(12,11,13);
        shapes[2]= new Triangle(12,11,44);
        for (Shape shape:shapes) {
            if (shape!=null) {
                System.out.printf("面积为:%.2f\n",shape.area());
                System.out.printf("周长为:%.2f\n",shape.perimeter());
                shape.setColor();
            }
        }

    }
}
