public class StringTest1 {

        public static void main(String[] args)
        {
            String s1="hello";
            String s2=new String("hello");
            if(s1.equals(s2)){
                System.out.println("相等");
            }else{
                System.out.println("不相等");
            }
        }


}
