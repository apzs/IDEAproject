public class a4_1_HotelTest {
    public static void main(String[] args){
        a4_1_Hotel hotel = new a4_1_Hotel("Hilton");
        System.out.println("in the main before change1:" + hotel.getName());
        hotel.change1(hotel);
        System.out.println("in the main after change1:" + hotel.getName());
        System.out.println();
        System.out.println("in the main before change2:" + hotel.getName());
        hotel.change2(hotel);
        System.out.println("in the main after change2:" + hotel.getName());
    }
}
