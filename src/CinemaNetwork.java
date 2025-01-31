import java.util.ArrayList;
import java.util.List;

public class CinemaNetwork {
    private String name;
    private List<Cinema> listOfCinemas = new ArrayList<>();

    public CinemaNetwork(String name) {
        this.name = name;
    }

    public void addCinema(Cinema cinema ) {
        listOfCinemas.add(cinema);
    }
}
