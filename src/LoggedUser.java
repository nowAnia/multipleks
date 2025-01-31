import java.util.ArrayList;
import java.util.List;

public class LoggedUser  extends User{
    private final List<Reservation> listOfReservations = new ArrayList<>();

    public LoggedUser(String name, String emial) {
        super(name, emial);
    }


    public void addReservation(Reservation reservation) {
        listOfReservations.add(reservation);
    }

    public void showUserReservations() {
            for (Reservation reservation : listOfReservations) {
                System.out.println(reservation.toString());

            }
    }
}
