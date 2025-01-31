import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Creating network
        CinemaNetwork cinemaNetwork = new CinemaNetwork("Multi kino");

        //creating cinema and adding to network Multi kino
        Cinema cinema1 = new Cinema("Kłębuszek", "ul.Kolorowa 17");
        cinemaNetwork.addCinema(cinema1);

        //Creating cinema rooms in cinema
        CinemaRoom cinemaRoom1 = new CinemaRoom(1);
        CinemaRoom cinemaRoom2 = new CinemaRoom(2);
        CinemaRoom cinemaRoom3 = new CinemaRoom(3);

        // creating movies available in this cinema, by default 2d
        Movie zmierzch = new Movie("Zmierzch", Genre.ROMANS, 120);
        Movie cisza = new Movie("Cisza", Genre.HORROR, 160);
        Movie cisza3d = new Movie("Cisza", Genre.HORROR, 160);
        cisza3d.setMovieType(MovieType.THREEDIMENSIONS);
        Movie zakreceni = new Movie("Zakręceni", Genre.COMEDY, 210);

        cinema1.addMovie(zakreceni);
        cinema1.addMovie(cisza3d);
        cinema1.addMovie(cisza);
        cinema1.addMovie(zmierzch);

        // check existence of movie
        System.out.println("=============checking existence of movie==========");

        cinema1.findMovie("Zmierzch");

        // creating events, which tell when, where, what you would like to watch
        Event event1 = new Event(WeekDay.MONDAY, 16, zmierzch, cinemaRoom1);
        Event event2 = new Event(WeekDay.MONDAY, 12, cisza, cinemaRoom1);
        Event event3 = new Event(WeekDay.MONDAY, 12, cisza3d, cinemaRoom3);
        Event event4 = new Event(WeekDay.TUESDAY, 19, zmierzch, cinemaRoom2);
        Event event5 = new Event(WeekDay.THURSDAY, 11, zakreceni, cinemaRoom1);
        Event event6 = new Event(WeekDay.FRIDAY, 16, zmierzch, cinemaRoom3);

        // creating schedule for this cinema per one week
        Schedule schedule = new Schedule();
        schedule.addEvent(event1);
        schedule.addEvent(event2);
        schedule.addEvent(event3);
        schedule.addEvent(event4);
        schedule.addEvent(event5);
        schedule.addEvent(event6);

        //displaying schedule and available seats in cinemaRoom1
        System.out.println("===================Schedule======================");
        schedule.showSchedul();
        System.out.println("===================Seats======================");
        cinemaRoom1.showAllSeats();

        //Creating users, ania is logged in, olek is not, but in both cases we need emails
        LoggedUser ania = new LoggedUser("Ania", "ania@example.com");
        NotLoggedUser olek = new NotLoggedUser("Olek", "olek@example.com");

        //setting clock
        LocalDateTime clock = LocalDateTime.of(2025, 2, 14, 18, 0);

        System.out.println("=================Creating reservations====================");

        System.out.println("=====Creating first reservation===========");
        //creating first reservation for ania(event1)
        Reservation reservation1 = cinema1.createReservation(event1, ania, clock, "A:7", "C:35");

        // Simulate time passing
        clock = clock.plusMinutes(3);

        System.out.println("=====Creating second reservation===========");
        //creating second reservation for olek(event1)
        Reservation reservation2 = cinema1.createReservation(event1, olek, clock, "A:8", "A:7");

        // Simulate time passing
        clock = clock.plusMinutes(5);

        System.out.println("=====Creating third reservation===========");
        //creating third reservation for ania(event2)
        Reservation reservation3 = cinema1.createReservation(event2, ania, clock, "A:7");

        System.out.println("============Attempting to purchase===========");
        //The result of the attempt to purchase the reservation
        if (reservation1 != null) {
            reservation1.buy();
        } else {
            System.out.println("Could not create reservation1");
        }

        if (reservation2 != null) {
            reservation2.buy();
        } else {
            System.out.println("Could not create reservation2");
        }

        if (reservation3 != null) {
            reservation3.buy();
        } else {
            System.out.println("Could not create reservation3");
        }

        //We could not purchase first reservation because time has passed, that is why second purchased was successful


        //Logged-in users might check their previous reservations
        System.out.println("============ Reservations of logged user =============");
        ania.showUserReservations();

    }
}