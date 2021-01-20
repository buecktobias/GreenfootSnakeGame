package game.helper;

import java.util.Objects;

/**
 * The game.helper.Vector2D class is a Vector in a two dimension environment.
 * It has the attributes
 *  x and y
 * @author tobias bück
 * @version 1
 */
final public class Vector2D {

    private final double x;
    private final double y;

    public Vector2D(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public static Vector2D getVectorByRotation(int rotation){
        double b1 = Math.cos(Math.toRadians(rotation)); // Degree
        double b2 = Math.sqrt(1 - Math.pow(Math.cos(Math.toRadians(rotation)), 2));
        if (rotation > 180){
            b2 = -b2;
        }
        return new Vector2D(b2, -b1);
    }

    public Vector2D scalarMultiplication(final double scalar){
        double newX = this.x * scalar;
        double newY = this.y * scalar;
        return new Vector2D(newX, newY);
    }

    public Vector2D addVector(Vector2D vector2D){
        double newX = this.getX() + vector2D.getX();
        double newY = this.getY() + vector2D.getY();
        return new Vector2D(newX, newY);
    }

    public Vector2D getRounded(){
        int newX = (int) Math.round(this.x);
        int newY = (int) Math.round(this.y);
        return new Vector2D(newX, newY);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getIntX() {
        return (int)Math.round(x);
    }

    public int getIntY() {
        return (int)Math.round(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D vector2D = (Vector2D) o;
        return Double.compare(vector2D.x, x) == 0 &&
                Double.compare(vector2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
