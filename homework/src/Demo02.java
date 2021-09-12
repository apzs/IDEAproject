import java.time.LocalDate;

public class Demo02 {
    public static void main(String[] args) {
        LocalDate begin =LocalDate.of(2000,11,18);
        LocalDate after =LocalDate.of(2020,12,9);
        System.out.println(begin.compareTo(after));


    }
}
