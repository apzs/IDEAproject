public class Demo1 {
    public static void main(String [] args) {
        int a[] = new int[5];
        boolean b[] = new boolean[5];
        System.out.println(a[1]);
        System.out.println(b[2]);
        int d = Integer.valueOf("1");
        System.out.println(d);
        int[] score = new int[]{26, 75, 48, 23, 75};
        int temp = score[0];
        for (int index = 1; index < 5; index++) {
            if (score[index] < temp) {
                temp = score[index];
            }
        }
        System.out.println(temp);
        System.out.println("       ");
        int i=0,s=0;
        do{
            if (i%2 == 0 ){
                i++;
                continue;
            }
            i++;
            s = s + i;
        } while (i<7);
        System.out.println(s);
    }
}
