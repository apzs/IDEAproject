public class a5_1_Sample {
        private int x;
        public a5_1_Sample(){
            x=1;
        }
        public void Sample(double f){
            this.x=1;
        }
        public int getX(){
            return x;
        }
        public static void main(String [] args){
            a5_1_Sample s=new a5_1_Sample();
            System.out.println(s.getX());
        }

}
