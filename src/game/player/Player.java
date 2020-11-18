package game.player;

import game.entity.movingactor.Rabbit;
import game.helper.Direction;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class game.player.Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private final Rabbit controlledRabbit;
    private final String KEY_MOVE_UP = "W";
    private final String KEY_MOVE_LEFT = "A";
    private final String KEY_MOVE_RIGHT = "D";
    private final String KEY_MOVE_DOWN = "S";
    private final String KEY_THROW = "T";

    /**
     * Constructor for objects of class game.player.Player
     */
    public Player(Rabbit controlledRobot) {
        this.controlledRabbit = controlledRobot;
        this.getImage().setTransparency(0);
    }

    @Override
    public void act() {
        super.act();
        this.controls();
    }

    public void controls() {
        if (Greenfoot.isKeyDown(this.KEY_MOVE_UP)) {
            this.controlledRabbit.moveDirection(new Direction(Direction.Values.UP));
        }
        if (Greenfoot.isKeyDown(this.KEY_MOVE_LEFT)) {
            this.controlledRabbit.moveDirection(new Direction(Direction.Values.LEFT));
        }
        if (Greenfoot.isKeyDown(this.KEY_MOVE_RIGHT)) {
            this.controlledRabbit.moveDirection(new Direction(Direction.Values.RIGHT));
        }
        if (Greenfoot.isKeyDown(this.KEY_MOVE_DOWN)) {
            this.controlledRabbit.moveDirection(new Direction(Direction.Values.DOWN));
        }
        if (Greenfoot.isKeyDown(this.KEY_THROW)) {
            this.controlledRabbit.shoot();
        }
    }
}
