package Theaterreserverungssystem;


import java.util.*;

public class Theate {
    private final String theateName;
    private List<Seat> seats = new ArrayList<>();
    static  final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat o1, Seat o2) {
            return o1.getPrice() < o2.getPrice()? -1: o1.getPrice() == o2.getPrice()? 0:1;
        }
    };
    public Theate(String theateName, int numRow, int seatProRow) {
        this.theateName = theateName;
        int lastRow = 'A' + numRow;
        for( char row = 'A'; row < lastRow; row++){
            for(int seatnum = 1; seatnum <= seatProRow; seatnum++){
                double price = 12.00;
                if(row < 'D' && seatnum >= 4 && seatnum <=9){
                    price = 14.00;
                }else if( row > 'F' || ( seatnum < 4 || seatnum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat( row+String.format("%02d", seatnum), price);
                seats.add(seat);
            }
        }

    }
    public String getTheateName() {
        return theateName;
    }
    public boolean reserveSeat( String seatNumber){
        int findSeat = Collections.binarySearch(seats, new Seat(seatNumber, 0), null);
        if( findSeat >= 0){
            return seats.get(findSeat).reserve();
        }else{
            System.out.println("There ist no Seat with SeatNamber "+ seatNumber);
            return false;
        }
    }
    public List getSeat(){
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat "+ seatNumber + " reserved!");
                return true;
            }
            System.out.println("Seat with the Number "+ seatNumber + " is reserved!");
            return false;
        }
        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat "+ seatNumber + " canceled!");
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareToIgnoreCase(o.getSeatNumber());
        }
    }
}