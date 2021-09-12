import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class a1_2_MonthlyCalendar {
    public static void main(String[] args)
    {
        System.out.println("请输入月份:");
        Scanner sc =new Scanner(System.in);
        int month  =sc.nextInt();
        LocalDate date = LocalDate.of(2017,month,1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, . . . , 7 = Sunday
        System.out.println(" * * * * * 2017年"+month+"月份 * * * * * ");
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s","日","一","二","三","四","五","六");
        System.out.println();
        for (int i = 1; i <= value&&value<7; i++)
            System.out.print("     ");
        while (date.getMonthValue() == month)
        {
            System.out.printf("%5d", date.getDayOfMonth());
            //日期+1
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 7)
            System.out.println();
    }
}
