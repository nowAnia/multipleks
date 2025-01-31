public enum MovieType {
    TWODIMENSIONS,
    THREEDIMENSIONS;

    public String getMovieType(MovieType movieType) {
        switch (movieType) {
            case TWODIMENSIONS: return "2d";
            case THREEDIMENSIONS: return "3d";
        }
      return "";
    }
}
