import java.util.Objects;

public class Seat {
    private SeatType type;
    private int number;
    private double price;
    private boolean isReserved= false;
    private char sector;

    public Seat(SeatType type, int number, char sector) {
        this.type = type;
        this.number = number;
        this.price = countPrice();
        this.sector = sector;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public double countPrice() {
        switch(type) {
            case SeatType.VIP -> {
                return 60.00;
            }
            case SeatType.STANDARD -> {
                return 50.00;
            }
            case SeatType.PROMO -> {
                return 40.00;
            }
            case SeatType.SUPERPROMO -> {
                return 30.00;
            }

        }
        return 0;
    }

    @Override
    public String toString() {
        return "{"+ sector +
                ":" + number +" "+( isReserved? "X":"O" )+'}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return number == seat.number && sector == seat.sector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, sector);
    }
}
