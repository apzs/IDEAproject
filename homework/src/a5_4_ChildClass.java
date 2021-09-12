public class a5_4_ChildClass extends a5_3_FatherClass{
    public a5_4_ChildClass(){
        System.out.println("ChildClass Create");
    }

    public static void main(String[] args){
        a5_3_FatherClass fc = new a5_3_FatherClass();
        a5_4_ChildClass cc = new a5_4_ChildClass();
    }
}


