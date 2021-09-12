public class a4_1_Hotel {
    private String name;

    public a4_1_Hotel(){
    }

    public a4_1_Hotel(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void change1(a4_1_Hotel hotel){
        hotel = new a4_1_Hotel("Starwood");
        System.out.println("in the change1:" + hotel.name);
    }

    public void change2(a4_1_Hotel hotel){
        hotel.name = "Startwood";
    }
}
