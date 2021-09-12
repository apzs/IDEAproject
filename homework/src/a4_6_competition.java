public class a4_6_competition {
    public static void main(String[] args) {
        System.out.printf("%-10s"," ");
        for(int j = 1 ; j <= 5; j++){
            System.out.printf("%-10s7",j);
        }
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%-10s",i);
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%-10s",i == j ? "~~~~" : i + "~" + j);
            }
            System.out.println();
        }
    }
}
