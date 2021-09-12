public class a5_15_Test {
    public static void main(String[] args) {
        a5_14_Student stu1 = new a5_14_Student("0001","李明","男",21);
        a5_14_Student stu2 = new a5_14_Student("0002","王萍","女",20);
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println("当前学生人数为："+ a5_14_Student.getCount());

        a5_14_Student.setCount(0);
        a5_14_Student[] stu = new a5_14_Student[10];
        stu[0]= new a5_14_Student("0001","李明","男",21);
        stu[1]= new a5_14_Student("0002","王萍","女",20);
        for(a5_14_Student student : stu){
            if(student!=null)
            System.out.println(student);
        }
        System.out.println("当前学生人数为："+ a5_14_Student.getCount());
    }
}
