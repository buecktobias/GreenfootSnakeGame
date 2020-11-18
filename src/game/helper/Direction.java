package game.helper;

import java.util.Random;

public class Direction {
    private final Values value;
    public enum Values {
        UP,
        DOWN,
        RIGHT,
        LEFT;
    }
    public Direction(Values value){
        this.value = value;
    }
    public static Direction getRandomDirection(){
        Values[] vals = Values.values();
        int randomIndex = new Random().nextInt(vals.length);
        return new Direction(vals[randomIndex]);
    }

    public Vector2D getVector2D() {
        switch (this.value){
            case UP:
                return new Vector2D(0, -1);
            case DOWN:
                return new Vector2D(0, 1);
            case LEFT:
                return new Vector2D(-1, 0);
            case RIGHT:
                return new Vector2D(1, 0);
            default:
                return new Vector2D(0, 0);
        }
    }
}

