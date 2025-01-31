public class Event {
   private WeekDay dayOfWeek;
   private int hour;
   private Movie movie;
   private CinemaRoom cinemaRoom;
   private EventCinemaRoom eventCinemaRoom;

    public Event(WeekDay dayOfWeek, int hour, Movie movie, CinemaRoom cinemaRoom) {
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.movie = movie;
        this.cinemaRoom = cinemaRoom;
        this.eventCinemaRoom = new EventCinemaRoom(cinemaRoom.getRoomNumber());
    }

    public EventCinemaRoom getEventCinemaRoom() {
        return eventCinemaRoom;
    }

    public void setEventCinemaRoom(EventCinemaRoom eventCinemaRoom) {
        this.eventCinemaRoom = eventCinemaRoom;
    }

    public WeekDay getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(WeekDay dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @Override
    public String toString() {
        return "Event{" +
                ", hour=" + hour +
                ", movie=" + movie +
                ", cinemaRoom=" + cinemaRoom.getRoomNumber() +
                '}';
    }
}
