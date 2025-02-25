package models;



/**
 * Coordinates sınıfı.
 *
 * @param x > -661
 * @param y null olamaz, > -493
 */
public record Coordinates(float x, float y) {

    public static Coordinates createCoordinates(float x, float y) {
        if (x <= -661 || y <= -493) {
            throw new IllegalArgumentException("Invalid data for creating a Ticket");
        }
        return new Coordinates(x, y);
    }

//    @Override
//    public boolean validate() {
//        return x > -661 && y > -493;
//    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Coordinates(float px, float py) &&
                Float.compare(this.x, px) == 0 &&
                Float.compare(this.y, py) == 0);
    }
}