public class a5_2_C {
        int x;
        String y;
        public a5_2_C() {
            this( "1");
            System.out.print(" one ");
        }
        public a5_2_C(String y) {
            this(1,  "2");
            System.out.print("two ");
        }
        public a5_2_C(int x, String y) {
            this.x = x;
            this.y = y;
            System.out.print("three ");
        }
        public static void main(String[] args) {
            a5_2_C c = new a5_2_C();
            System.out.println(c.x +  "" + c.y);
        }


}
