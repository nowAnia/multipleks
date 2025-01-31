import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cinema {
    private String name;
    private String address;
    private List<CinemaRoom> cinemaRooms = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private List<Reservation> allReservations = new ArrayList<>();
    private Schedule currentWeekSchedule;


    public Cinema(String name, String address) {
        this.name = name;

        this.address = address;
    }

    public void addCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRooms.add(cinemaRoom);
    }

    public void showMovies() {
        for (Movie film : movies) {
            System.out.println(film.toString());
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void findMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                System.out.println("Movie "+ movie.getTitle() +" is available in our cinema");
                System.out.println("Check our schedul");
                return;
            }
        }
        System.out.println("Movie "+ title +" is not available in this cinema");
    }


    public Reservation createReservation(Event event, User user, LocalDateTime time, String... seats) {
        EventCinemaRoom cinemaRoom = event.getEventCinemaRoom();
        List<Seat> seatsToBeReserved = new ArrayList<>();
        double totalPrice = 0;

        for (String seat : seats) {
            Seat returnedSeat = cinemaRoom.getSeat(seat);
            if (returnedSeat != null) {
                if(returnedSeat.isReserved()) {
                    Optional<Reservation> otherReservation = allReservations.stream().filter(reservation -> reservation.containsSeat(returnedSeat)).findFirst();
                    if (otherReservation.isPresent()) {
                        if (otherReservation.get().isValid(time)) {
                            System.out.println("Seat :" + returnedSeat + " is already reserved.");
                            System.out.println("Failed to make reservation. Try again with different seats");
                            return null;
                        } else {
                            System.out.println("Seat: " + returnedSeat + " used to be reserved. But the previous reservation expired! You're lucky.");
                            otherReservation.get().expire();
                            returnedSeat.setReserved(true);
                            seatsToBeReserved.add(returnedSeat);
                            totalPrice += returnedSeat.countPrice();
                        }
                    } else {
                        throw new RuntimeException("An error occurred. A seat " + returnedSeat + " seems to be reserved but there's no matching reservation in the cinemaRoom");
                    }
                } else {
                    returnedSeat.setReserved(true);
                    seatsToBeReserved.add(returnedSeat);
                    totalPrice += returnedSeat.countPrice();
                }
            } else {
                System.out.println("Seat does not exist");
                System.out.println("Failed to make reservation. Try again with different seats");
                return null;
            }
        }

        System.out.println("The reservation was successful");

        Reservation reservation = new Reservation(event, user.getEmail(), seatsToBeReserved, time, totalPrice);
        if (user.getClass() == LoggedUser.class) {

           ((LoggedUser) user).addReservation(reservation);
        }
        this.allReservations.add(reservation);
        System.out.println(reservation);
        return reservation;
    }


    public void showSchedul() {
        currentWeekSchedule.showSchedul();
    }

    ///  all getters

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<CinemaRoom> getCinemaRooms() {
        return cinemaRooms;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Reservation> getAllReservations() {
        return allReservations;
    }

}
