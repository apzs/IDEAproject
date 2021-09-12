import static java.lang.Math.*;
public class Circle extends Shape{
    private double radius;
    private boolean isCircle=true;

    public Circle(double radius) {
        this.radius = radius;
        if (radius<=0){
            isCircle=false;
        }
    }

    @Override
    public double area() {
        if(isCircle) {
            return PI * pow(radius, 2);
        }else {
            System.out.println("无法计算面积");
            return -1;
        }
    }

    @Override
    public double perimeter() {
        if(isCircle) {
            return 2 * PI * radius;
        }else {
            System.out.println("无法计算周长");
            return -1;
        }
    }

    @Override
    public void setColor() {
        if (isCircle){
        System.out.println("改变圆形的颜色");
        }else {
            System.out.println("无法改变颜色");
        }
    }
}
