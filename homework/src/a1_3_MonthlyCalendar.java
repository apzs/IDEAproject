/***
     *
     * 打印某年某月日历
     *
     */
    public class a1_3_MonthlyCalendar {

        public static void main(String[] args) {
            printCalendar(2017,5);
        }

        public static boolean isLeap(int year){
            if (year%4==0 && year%100!=0 || year%400==0){
                return true;
            }else{
                return false;
            }
        }

        //计算该月第一天是星期几
        public static int getDayOfWeek(int year, int month){
            int x=0;

            for(int m=1; m<month; m++){
                x = x+getDays(year, m);
            }

            return (x+0)%7;	//2017年第一天是星期日
        }

        //计算每月有多少天
        public static int getDays(int year, int month)
        {
            switch(month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: return 31;
                case 4:
                case 6:
                case 9:
                case 11: return 30;
                case 2:  if(isLeap(year))
                    return 29;
                else
                    return 28;
            }
            return 0;
        }

        //打印星期几的标题
        public static void printTitle(){
            System.out.printf("%4s%4s%4s%4s%4s%4s%4s","日","一","二","三","四","五","六");
        }

        //打印日历
        public static void printCalendar(int year, int month){

            System.out.println("*****"+year+"年"+month+"月份*****");
            printTitle();
            System.out.println();

            int day_of_week = getDayOfWeek(year, month);
            for(int i=0; i<day_of_week; i++){
                System.out.print("   ");
            }

            for(int day=1; day<=getDays(year, month); day++){
                System.out.printf("%3d",day);
                if((day+day_of_week)%7==0){
                    System.out.println();
                }
            }
            System.out.printf("\n\n");
        }
    }