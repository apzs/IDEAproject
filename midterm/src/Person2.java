public class Person2 {
    String name;
    int age;
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) {
        Person2 c = new Person2( "Peter" , 17);
        System. out .println(c.name + " is " + c.age + " years old!" );
    }

}
