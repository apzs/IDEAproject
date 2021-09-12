import java.util.Random;

/**
 * @Data:2021/5/3
 */
public class fun {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 1; i <= 220; i++) {
            int length = r.nextInt(3)+8;
            String s = "";
            for (int j = 0; j < length; j++) {
                    s = s + r.nextInt(10);
            }
        }


        String[] s = new String[]{"男", "女"};
        for (int i = 0; i < 220; i++) {
//            System.out.println(s[r.nextInt(2)]);
        }

        for (int i = 0; i < 220; i++) {
            System.out.println(r.nextInt(50)+50);
        }

    }
}
