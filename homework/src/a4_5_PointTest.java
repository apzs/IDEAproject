public class a4_5_PointTest {
    public static void main(String[] args) {
        a4_5_Point p1 = new a4_5_Point(43,27);
        System.out.printf("%.2f\n", p1.distance());
        System.out.printf("%.2f\n", p1.distance(59,61));
        a4_5_Point p2 = new a4_5_Point(40,54);
        System.out.printf("%.2f\n", p1.distance(p2));
    }
}
