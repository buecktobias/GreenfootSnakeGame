package game.entity;

import game.Direction;
import game.Vector2D;
import game.entity.Entity;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.Random;

public abstract class MovingActor extends Entity {
    private Vector2D position;
    private Vector2D currentSpeed;
    private int speed;
    private Direction lastDirection;

    public MovingActor(int speed, GreenfootImage greenfootImage) {
        super(greenfootImage);
        this.currentSpeed = new Vector2D(0,0);
        this.position = new Vector2D(100, 100);
        this.speed = speed;
        this.lastDirection = new Direction(Direction.Values.RIGHT);
    }

    public void act(){
        this.moveBy(this.getCurrentSpeed());
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.position = new Vector2D(this.getX(), this.getY());
    }

    protected void doRandomMovement(double changeDirectionProbability, double probabilityNoMovement){
        Random r = new Random();
        double p = r.nextDouble();
        if (p < changeDirectionProbability){
            this.changeToARandomDirectionOrStop(probabilityNoMovement);
        }
    }

    protected void stopMovement(){
        this.changeCurrentSpeed(new Vector2D(0,0));
    }
    protected void changeToARandomDirectionOrStop(double stopProb){
        Random r = new Random();
        double p = r.nextDouble();
        if (p < stopProb){
            this.stopMovement();
        }else{
            this.changeToARandomDirection();
        }
    }

    protected void changeToARandomDirection(){
        this.changeDirection(Direction.getRandomDirection());
    }

    protected void changeDirection(Direction d){
        this.lastDirection = d;
        changeCurrentSpeed(d.getVector2D().scalarMultiplication(this.speed));
    }

    protected void changeCurrentSpeed(Vector2D newSpeed){
        this.currentSpeed = newSpeed;
    }

    protected void moveDirection(Direction d){
        this.lastDirection = d;
        this.moveBy(d.getVector2D().scalarMultiplication(this.speed));
    }

    protected void moveBy(Vector2D vector2D){
        Vector2D newPosition = this.position.addVector(vector2D);
        this.turnTowards(newPosition.getIntX(), newPosition.getIntY());
        this.setPosition(newPosition);
    }

    public Vector2D getPosition() {
        return position;
    }

    @Override
    public void setLocation(int x, int y) {
        Vector2D v = new Vector2D(x, y);
        this.setPosition(v);
    }

    public void setPosition(Vector2D position) {
        this.position = position;
        super.setLocation(position.getIntX(), position.getIntY());
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

    public Direction getLastDirection() {
        return lastDirection;
    }
}
