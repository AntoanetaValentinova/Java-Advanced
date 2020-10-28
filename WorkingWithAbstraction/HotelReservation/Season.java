package HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier=multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
