import java.util.Objects;

public class Movie {
    private String title;
    private Genre genre;
    private int duration;
    private MovieType movieType;

    public Movie(String title, Genre genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.movieType = MovieType.TWODIMENSIONS;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", duration=" + duration +
                " "+ movieType.getMovieType(movieType)+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, duration);
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}
