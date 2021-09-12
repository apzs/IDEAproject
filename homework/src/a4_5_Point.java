public class a4_5_Point {
    int x;
    int y;

    public a4_5_Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public a4_5_Point(int x) {
        this.x = x;
    }

    public double distance(){
        return Math.sqrt(x*x + y*y);
    }
    public double distance(int x ,int y){
        return Math.sqrt(Math.pow(x - this.x,2) + Math.pow(y - this.y,2));
    }
    public double distance(a4_5_Point point){
        return Math.sqrt(Math.pow(x - point.x,2) + Math.pow(y - point.y,2));
    }
}
