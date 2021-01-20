package game.entity.movingactor;

import game.entity.Entity;
import game.helper.Vector2D;
import greenfoot.GreenfootImage;
import greenfoot.World;


public abstract class MovingActor extends Entity {
    private Vector2D position;
    private Vector2D currentSpeed;
    private Vector2D currentAcceleration;
    private int speed;

    protected MovingActor(int speed, GreenfootImage greenfootImage) {
        super(greenfootImage);
        this.currentSpeed = new Vector2D(0,0);
        this.currentAcceleration = new Vector2D(0, 0);
        this.position = new Vector2D(100, 100);
        this.speed = speed;
    }

    public void act(){
        this.currentSpeed = currentSpeed.addVector(this.currentAcceleration);
        this.moveBy(this.getCurrentSpeed());
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.position = new Vector2D(this.getX(), this.getY());
    }


    protected void stopMovement(){
        this.changeCurrentSpeed(new Vector2D(0,0));
    }


    protected void changeCurrentSpeed(Vector2D newSpeed){
        this.currentSpeed = newSpeed;
    }

    protected void moveBy(Vector2D vector2D){
        Vector2D newPosition = this.position.addVector(vector2D);
        this.turnTowards(newPosition.getIntX(), newPosition.getIntY());
    }

    public Vector2D getPosition() {
        return position;
    }




    public void setCurrentSpeed(Vector2D currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Vector2D getCurrentSpeed() {
        return this.currentSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vector2D getCurrentAcceleration() {
        return currentAcceleration;
    }

    public void setCurrentAcceleration(Vector2D currentAcceleration) {
        this.currentAcceleration = currentAcceleration;
    }
}
