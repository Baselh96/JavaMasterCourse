package Theaterreserverungssystem;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Theate theate = new Theate("xy", 10, 12);
        theate.getSeat().add(theate.new Seat("B00", 13.00));
        theate.getSeat().add(theate.new Seat("A00", 13.00));
        Collections.sort(theate.getSeat());
        Collections.sort(theate.getSeat(), Theate.PRICE_ORDER);

        Collection list = theate.getSeat();
        print(list);
        theate.reserveSeat("A01");
        theate.reserveSeat("A02");
        theate.reserveSeat("A01");


    }
    public static void print(Collection<Theate.Seat> list){
        for(Theate.Seat seat : list){
            System.out.println("Seatnumber: "+ seat.getSeatNumber() + " \tPrice: "+ seat.getPrice());
        }
    }
}
