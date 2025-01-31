import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;

public class Reservation {
    private Event choosenEvent;
    private List<Seat> reservedSeats;
    private String userEmail;
    private LocalDateTime createdAt;
    private LocalDateTime validUnitl;
    private Status status;
    private double price;

    public Reservation(Event choosenEvent, String userEmail, List<Seat> reservedSeats, LocalDateTime time, double price) {
        this.choosenEvent = choosenEvent;
        this.userEmail = userEmail;
        this.reservedSeats = reservedSeats;
        this.createdAt = time;
        this.validUnitl = createdAt.plusMinutes(3);
        this.status = Status.RESERVED;
        this.price = price;
    }

    public void buy() {
        switch(status) {
            case CANCELLED -> System.out.println("This reservation has expired! " + this.userEmail + " :(");
            case PURCHASED -> System.out.println("This reservation is already purchased");
            case RESERVED -> {
                this.status = Status.PURCHASED;
                System.out.println("Successfully purchased reservation! Enjoy your movie "+ this.userEmail + " :)");
            }
        }
    }

    public void expire() {
        this.status = Status.CANCELLED;
        this.reservedSeats.forEach(seat -> seat.setReserved(false));
    }

    public boolean containsSeat(Seat seat) {
        return this.reservedSeats.stream().anyMatch(seat1 -> seat1.equals(seat));
    }


    public boolean isValid(LocalDateTime time) {
        if(this.status == Status.PURCHASED) {
            return true;
        }
        return time.isBefore(validUnitl);
    }


    @Override
    public String toString() {
        return "Your reservation{" +
                "title=" + choosenEvent.getMovie() +
                "hour=" + choosenEvent.getHour() +
                "cinemaRoom=" + choosenEvent.getCinemaRoom() +
                ", reservedSeats=" + reservedSeats +
                ", userEmail= " + userEmail +
                ", total amount: " + price+
                '}';
    }
}
