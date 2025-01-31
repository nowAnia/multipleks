import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    private int roomNumber;
    private int totalSeatsNumber = 100;
    List<Seat> listOfSeats = new ArrayList<>();

    public CinemaRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        selectAllSeats();

    }

    public Seat getSeat(String seatCode) {
        char sector = seatCode.charAt(0);
        String[] array = seatCode.split(":");
        int number = Integer.parseInt(array[1]);
        return this.getSeat(sector, number);
    }

    public Seat getSeat(char sektor, int number) {
        for (Seat seat : listOfSeats) {
            if (seat.getSector() == sektor && seat.getNumber() == number) {
                return seat;
            }
        }
        return null;
    }

    private void selectAllSeats() {
        for(int i =1 ; i <= 10; i++){
            assert listOfSeats != null;
            listOfSeats.add(new Seat(SeatType.VIP, i, 'A'));
        }
        for(int i =11 ; i <= 30 ; i++){
            listOfSeats.add(new Seat(SeatType.STANDARD, i, 'B'));
        }
        for(int i =31 ; i <= 60 ; i++){
            listOfSeats.add(new Seat(SeatType.PROMO, i, 'C'));
        }
        for(int i =61 ; i <= 100 ; i++){
            listOfSeats.add(new Seat(SeatType.SUPERPROMO, i, 'D'));
        }

    }

    public void showAllSeats() {
        System.out.println("Sector VIP");
        for (Seat seat : listOfSeats) {
            if (seat.getSector() == 'A'){
                System.out.print(seat);
            }
        }
        System.out.println();
        System.out.println("Sector STANDARD");
        for (Seat seat : listOfSeats) {
            if (seat.getSector() == 'B'){
                System.out.print(seat);
            }
        }
        System.out.println();
        System.out.println("Sector PROMO");
        for (Seat seat : listOfSeats) {
            if (seat.getSector() == 'C'){
                System.out.print(seat);
            }
        }
        System.out.println();
        System.out.println("Sector SUPERPROMO");
        for (Seat seat : listOfSeats) {
            if (seat.getSector() == 'D'){
                System.out.print(seat);
            }
        }
        System.out.println();
    }







}
