public class a2_6_Homework {
    public static void main(String[] args) {
        int random = 0;
        int temp = 0;
        int[] a = new int[4];
        int sum = 0;
        do {
             random= (int)( Math.random() * (10000) );
        }while (random < 1000);
        System.out.println("加密前为:" + random);
        for(int i = 3; i >= 0 ; i--){
            a[i] = (random % 10 + 5 ) % 10;
            random = random / 10;
        }

        temp = a[0];
        a[0] = a[3];
        a[3] = temp;
        temp = a[1];
        a[1] = a[2];
        a[2] = temp;
        System.out.print("加密后为：");
        for (int m:a) {
            System.out.print(m);
        }
    }
}
